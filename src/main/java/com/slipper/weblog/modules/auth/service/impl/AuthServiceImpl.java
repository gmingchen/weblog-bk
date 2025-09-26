package com.slipper.weblog.modules.auth.service.impl;

import com.slipper.weblog.common.enums.LoginTypeEnum;
import com.slipper.weblog.core.validator.ValidatorUtils;
import com.slipper.weblog.modules.auth.covert.AuthConvert;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void sendCaptcha(CaptchaReqVO reqVO) {
        CaptchaEntity captchaEntity = captchaService.create(reqVO.getUuid());

        EmailSetting setting = mailService.getSetting();

        String reg = "\\$\\{captcha}\\}";
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
        return null;
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
     * @param qqOpenId QQOpenId
     * @return
     */
    private UserEntity registerByQqOpenId(String qqOpenId) {
        return null;
    }
}
