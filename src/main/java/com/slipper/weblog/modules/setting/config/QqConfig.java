package com.slipper.weblog.modules.setting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
    /**
     * QQ互联 成功授权后的回调地址
     */
    private String redirectUri;
}
