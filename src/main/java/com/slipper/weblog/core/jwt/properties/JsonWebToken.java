package com.slipper.weblog.core.jwt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gumingchen
 */
@Data
@Component
@ConfigurationProperties("json-web-token")
public class JsonWebToken {
    /**
     * token 键值
     */
    private String key;
    /**
     * 秘钥
     */
    private String secret;
    /**
     * 过期是时间（秒）
     */
    private Long expire;
}
