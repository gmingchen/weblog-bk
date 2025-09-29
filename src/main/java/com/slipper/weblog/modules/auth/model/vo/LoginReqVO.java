package com.slipper.weblog.modules.auth.model.vo;

import com.slipper.weblog.common.enums.LoginTypeEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class LoginReqVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 邮箱
     */
    private String email;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 验证码
     */
    private String captcha;
    /**
     * accessToken
     */
    private String accessToken;
    /**
     * 登录类型 1-邮箱 2-QQ
     */
    @NotNull(message = "登录类型不能为空")
    @Enum(LoginTypeEnum.class)
    private Integer type;
}
