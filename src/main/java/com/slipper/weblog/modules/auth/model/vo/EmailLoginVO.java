package com.slipper.weblog.modules.auth.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class EmailLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String captcha;

}
