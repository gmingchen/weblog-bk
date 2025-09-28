package com.slipper.weblog.modules.auth.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.slipper.weblog.common.enums.LoginTypeEnum;
import com.slipper.weblog.common.enums.ResultCodeEnum;
import com.slipper.weblog.common.enums.SexEnum;
import com.slipper.weblog.core.security.utils.SecurityUtils;
import com.slipper.weblog.core.validator.ValidatorUtils;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.auth.config.QqConfig;
import com.slipper.weblog.modules.auth.covert.AuthConvert;
import com.slipper.weblog.modules.auth.model.dto.LoginUserDTO;
import com.slipper.weblog.modules.auth.model.dto.QqAuthDTO;
import com.slipper.weblog.modules.auth.model.dto.QqUserDTO;
import com.slipper.weblog.modules.auth.model.dto.TokenDTO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaReqVO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginVO;
import com.slipper.weblog.modules.auth.model.vo.LoginReqVO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginVO;
import com.slipper.weblog.modules.auth.service.AuthService;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import com.slipper.weblog.modules.captcha.service.CaptchaService;
import com.slipper.weblog.modules.mail.service.MailService;
import com.slipper.weblog.modules.setting.model.dto.EmailSetting;
import com.slipper.weblog.modules.token.entity.TokenEntity;
import com.slipper.weblog.modules.token.service.TokenService;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Matcher;

/**
 * @author gumingchen
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private MailService mailService;
    @Autowired
    private QqConfig qqConfig;

    @Override
    public void sendCaptcha(CaptchaReqVO reqVO) {
        CaptchaEntity captchaEntity = captchaService.create(reqVO.getUuid());

        EmailSetting setting = mailService.getSetting();

        String reg = "\\$\\{captcha\\}";
        String content = setting.getContent().replaceFirst(reg, Matcher.quoteReplacement(captchaEntity.getCode()));

        mailService.send(reqVO.getEmail(), setting.getTitle(), content);
    }

    @Override
    public TokenDTO login(LoginReqVO reqVO) {
        if (reqVO.getType().equals(LoginTypeEnum.EMAIL.getCode())) {
            EmailLoginVO emailLoginVO = AuthConvert.INSTANCE.convertEmail(reqVO);
            return this.emailLogin(emailLoginVO);
        } else if (reqVO.getType().equals(LoginTypeEnum.QQ.getCode())) {
            QqLoginVO qqLoginVO = AuthConvert.INSTANCE.convertQq(reqVO);
            return this.qqLogin(qqLoginVO);
        }
        return null;
    }

    @Override
    public TokenDTO emailLogin(EmailLoginVO vo) {
        ValidatorUtils.validate(vo);

        Boolean validate = captchaService.validate(vo.getUuid(), vo.getCaptcha());
        if (Boolean.FALSE.equals(validate)) {
            throw new RunException(ResultCodeEnum.CAPTCHA_ERROR);
        }
        captchaService.deleteByUuid(vo.getUuid());

        UserEntity userEntity = userService.queryUserByEmail(vo.getEmail());
        if (userEntity == null) {
            userEntity = registerByEmail(vo.getEmail());
        }

        TokenEntity tokenEntity = tokenService.create(userEntity.getId());
        return AuthConvert.INSTANCE.convert(tokenEntity);
    }

    @Override
    public TokenDTO qqLogin(QqLoginVO vo) {
        ValidatorUtils.validate(vo);

        QqAuthDTO qqAuthDTO = this.qqAuth(vo.getAccessToken());
        UserEntity userEntity = userService.queryUserByQqOpenId(qqAuthDTO.getOpenid());
        if (userEntity == null) {
            userEntity = registerByQqOpenId(vo.getAccessToken(), qqAuthDTO.getOpenid());
        }

        TokenEntity tokenEntity = tokenService.create(userEntity.getId());
        return AuthConvert.INSTANCE.convert(tokenEntity);
    }

    @Override
    public LoginUserDTO getLoginUser() {
        return AuthConvert.INSTANCE.convert(SecurityUtils.getLoginUser());
    }

    @Override
    public Boolean validateToken(String token) {
        return tokenService.validate(token);
    }

    @Override
    public UserEntity queryUserByToken(String token) {
        return Optional.ofNullable(tokenService.queryUserIdByToken(token))
                .map(userService::getById)
                .orElse(null);
    }

    /**
     * 通过邮箱注册
     * @param email 邮箱
     * @return
     */
    private UserEntity registerByEmail(String email) {
        UserCreateDTO userCreateDTO = new UserCreateDTO()
                .setEmail(email)
                .setNickname(email);
        return userService.create(userCreateDTO);
    }

    /**
     * 通过QQOpenId注册
     * @param accessToken accessToken
     * @param qqOpenId QQOpenId
     * @return
     */
    private UserEntity registerByQqOpenId(String accessToken, String qqOpenId) {
        QqUserDTO qqUser = this.getQqUser(accessToken, qqOpenId);

        String avatar = StringUtils.isNotBlank(qqUser.getFigureurl_qq_2())
                ? qqUser.getFigureurl_qq_2()
                : qqUser.getFigureurl_qq_1();
        Integer sex = SexEnum.UNKNOWN.getCode();
        if (qqUser.getGender_type() == 2) {
            sex = SexEnum.MALE.getCode();
        } else if (qqUser.getGender_type() == 1) {
            sex = SexEnum.FEMALE.getCode();
        }

        UserCreateDTO userCreateDTO = new UserCreateDTO()
            .setQqOpenId(qqOpenId)
            .setNickname(qqUser.getNickname())
            .setAvatar(avatar)
            .setSex(sex);
        return userService.create(userCreateDTO);
    }

    /**
     * QQ授权
     * @param accessToken 凭证
     * @return
     */
    private QqAuthDTO qqAuth(String accessToken) {
        String url = "https://graph.qq.com/oauth2.0/me";

        HashMap<String, Object> params = new HashMap<>(2);
        params.put("access_token", accessToken);
        params.put("fmt", "json");

        String result = HttpUtil.get(url, params);
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject.toJavaObject(QqAuthDTO.class);
    }

    private QqUserDTO getQqUser(String accessToken, String openId) {
        String url = "https://graph.qq.com/user/get_user_info";

        HashMap<String, Object> params = new HashMap<>(2);
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("oauth_consumer_key", qqConfig.getAppId());

        String result = HttpUtil.get(url, params);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject.toJavaObject(QqUserDTO.class);
    }

}
