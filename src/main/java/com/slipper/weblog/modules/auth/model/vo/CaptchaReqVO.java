package com.slipper.weblog.modules.auth.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class CaptchaReqVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * UUID
     */
    @NotBlank(message = "UUID不能为空")
    private String uuid;
}
