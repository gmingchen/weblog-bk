package com.slipper.weblog.modules.auth.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class TokenDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 生成的 Token
     */
    private String token;
    /**
     * Token 过期时间
     */
    private LocalDateTime expiredAt;
}
