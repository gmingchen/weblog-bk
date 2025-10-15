package com.slipper.weblog.modules.setting.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gumingchen
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileConfig {
    /**
     * 域名
     */
    private String domain;
    /**
     * 虚拟路径路径
     */
    private String url;
    /**
     * 物理路径
     */
    private String path;
}
