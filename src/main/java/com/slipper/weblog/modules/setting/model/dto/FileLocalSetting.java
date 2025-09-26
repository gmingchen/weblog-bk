package com.slipper.weblog.modules.setting.model.dto;

import com.slipper.weblog.modules.setting.model.SettingValue;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class FileLocalSetting implements SettingValue {
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
