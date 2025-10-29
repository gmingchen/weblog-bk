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
import com.slipper.weblog.modules.auth.covert.AuthConvert;
import com.slipper.weblog.modules.auth.model.dto.LoginUserVO;
import com.slipper.weblog.modules.auth.model.dto.QqAuthVO;
import com.slipper.weblog.modules.auth.model.dto.QqUserVO;
import com.slipper.weblog.modules.auth.model.dto.TokenVO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaDTO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginDTO;
import com.slipper.weblog.modules.auth.model.vo.LoginDTO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginDTO;
import com.slipper.weblog.modules.auth.service.AuthService;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import com.slipper.weblog.modules.captcha.service.CaptchaService;
import com.slipper.weblog.modules.mail.service.MailService;
import com.slipper.weblog.modules.setting.model.dto.QqSetting;
import com.slipper.weblog.modules.setting.service.SettingService;
import com.slipper.weblog.modules.token.entity.TokenEntity;
import com.slipper.weblog.modules.token.service.TokenService;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

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
    private SettingService settingService;

    @Override
    public void sendCaptcha(CaptchaDTO dto) {
        CaptchaEntity captchaEntity = captchaService.create(dto.getUuid());
        mailService.sendCaptcha(dto.getEmail(), captchaEntity.getCode());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public TokenVO login(LoginDTO dto) {
        if (dto.getType().equals(LoginTypeEnum.EMAIL.getCode())) {
            EmailLoginDTO emailLoginVO = AuthConvert.INSTANCE.convertEmail(dto);
            return this.emailLogin(emailLoginVO);
        } else if (dto.getType().equals(LoginTypeEnum.QQ.getCode())) {
            QqLoginDTO qqLoginVO = AuthConvert.INSTANCE.convertQq(dto);
            return this.qqLogin(qqLoginVO);
        }
        return null;
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public TokenVO emailLogin(EmailLoginDTO dto) {
        ValidatorUtils.validate(dto);

        Boolean validate = captchaService.validate(dto.getUuid(), dto.getCaptcha());
        if (Boolean.FALSE.equals(validate)) {
            throw new RunException(ResultCodeEnum.CAPTCHA_ERROR);
        }
        captchaService.deleteByUuid(dto.getUuid());

        UserEntity userEntity = userService.queryUserByEmail(dto.getEmail());
        if (userEntity == null) {
            userEntity = registerByEmail(dto.getEmail());
        }

        userService.updateLoginTime(userEntity.getId(), LocalDateTime.now());

        TokenEntity tokenEntity = tokenService.create(userEntity.getId());
        return AuthConvert.INSTANCE.convert(tokenEntity);
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public TokenVO qqLogin(QqLoginDTO dto) {
        ValidatorUtils.validate(dto);

        QqAuthVO qqAuthDTO = this.qqAuth(dto.getAccessToken());
        UserEntity userEntity = userService.queryUserByQqOpenId(qqAuthDTO.getOpenid());
        if (userEntity == null) {
            userEntity = registerByQqOpenId(dto.getAccessToken(), qqAuthDTO.getOpenid());
        }

        userService.updateLoginTime(userEntity.getId(), LocalDateTime.now());

        TokenEntity tokenEntity = tokenService.create(userEntity.getId());
        return AuthConvert.INSTANCE.convert(tokenEntity);
    }

    @Override
    public LoginUserVO getLoginUser() {
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
        QqUserVO qqUser = this.getQqUser(accessToken, qqOpenId);

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
    private QqAuthVO qqAuth(String accessToken) {
        String url = "https://graph.qq.com/oauth2.0/me";

        HashMap<String, Object> params = new HashMap<>(2);
        params.put("access_token", accessToken);
        params.put("fmt", "json");

        String result = HttpUtil.get(url, params);
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject.toJavaObject(QqAuthVO.class);
    }

    private QqUserVO getQqUser(String accessToken, String openId) {
        String url = "https://graph.qq.com/user/get_user_info";

        QqSetting qqSetting = settingService.queryQq();

        HashMap<String, Object> params = new HashMap<>(2);
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("oauth_consumer_key", qqSetting.getAppId());

        String result = HttpUtil.get(url, params);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject.toJavaObject(QqUserVO.class);
    }

}
