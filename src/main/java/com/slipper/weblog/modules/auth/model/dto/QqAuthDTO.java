package com.slipper.weblog.modules.auth.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class QqAuthDTO {
    /**
     * clientId
     */
    private String clientId;
    /**
     * openId
     */
    private String openid;
}
