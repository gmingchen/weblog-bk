package com.slipper.weblog.modules.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gumingchen
 */
@Data
@Component
@ConfigurationProperties(prefix = "qq")
public class QqConfig {
    /**
     * QQ互联 APP ID
     */
    private String appId;
    /**
     * QQ互联 APP Key
     */
    private String appKey;
}
