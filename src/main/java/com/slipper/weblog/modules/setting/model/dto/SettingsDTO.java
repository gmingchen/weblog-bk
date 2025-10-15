package com.slipper.weblog.modules.setting.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class SettingsDTO {
    /**
     * QQ配置
     */
    private QqSettingDTO qqSetting;
}
