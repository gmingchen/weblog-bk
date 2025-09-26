package com.slipper.weblog.modules.auth.service;

import com.slipper.weblog.modules.auth.model.dto.TokenDTO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaReqVO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginVO;
import com.slipper.weblog.modules.auth.model.vo.LoginReqVO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginVO;
import com.slipper.weblog.modules.user.entity.UserEntity;

/**
 * @author gumingchen
 */
public interface AuthService {

    /**
     * 发送验证码
     * @param reqVO
     */
    void sendCaptcha(CaptchaReqVO reqVO);

    /**
     * 登录
     * @param reqVO
     * @return
     */
    TokenDTO login(LoginReqVO reqVO);

    /**
     * 邮箱登录
     * @param vo
     * @return
     */
    TokenDTO emailLogin(EmailLoginVO vo);

    /**
     * QQ登录
     * @param vo
     * @return
     */
    TokenDTO qqLogin(QqLoginVO vo);

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
