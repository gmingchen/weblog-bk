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
public class QqLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * accessToken
     */
    @NotBlank(message = "accessToken不能为空")
    private String accessToken;
}
