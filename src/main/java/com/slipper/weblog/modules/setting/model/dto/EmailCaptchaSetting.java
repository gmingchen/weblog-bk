package com.slipper.weblog.modules.setting.model.dto;

import com.slipper.weblog.modules.setting.model.SettingValue;

import javax.validation.constraints.NotBlank;

/**
 * @author gumingchen
 */
public class EmailCaptchaSetting implements SettingValue {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
}
