package com.slipper.weblog.modules.auth.service;

import com.slipper.weblog.modules.auth.model.dto.LoginUserVO;
import com.slipper.weblog.modules.auth.model.dto.TokenVO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaDTO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginDTO;
import com.slipper.weblog.modules.auth.model.vo.LoginDTO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginDTO;
import com.slipper.weblog.modules.user.entity.UserEntity;

/**
 * @author gumingchen
 */
public interface AuthService {

    /**
     * 发送验证码
     * @param dto
     */
    void sendCaptcha(CaptchaDTO dto);

    /**
     * 登录
     * @param dto
     * @return
     */
    TokenVO login(LoginDTO dto);

    /**
     * 邮箱登录
     * @param dto
     * @return
     */
    TokenVO emailLogin(EmailLoginDTO dto);

    /**
     * QQ登录
     * @param dto
     * @return
     */
    TokenVO qqLogin(QqLoginDTO dto);

    /**
     * 获取登录用户信息
     * @return
     */
    LoginUserVO getLoginUser();

    /**
     * 校验token
     * @param token
     * @return
     */
    Boolean validateToken(String token);

    /**
     * 通过Token查询用户
     * @param token token
     * @return
     */
    UserEntity queryUserByToken(String token);
}
