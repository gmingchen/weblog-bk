package com.slipper.weblog.modules.setting.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class SettingsVO {
    /**
     * QQ配置
     */
    private QqSettingVO qqSetting;

    /**
     * 网站设置
     */
    private WebsiteSettingVO websiteSetting;
}
