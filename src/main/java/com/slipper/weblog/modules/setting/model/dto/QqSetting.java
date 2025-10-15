package com.slipper.weblog.modules.setting.model.dto;

import com.slipper.weblog.modules.setting.model.SettingValue;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class QqSetting implements SettingValue {
    /**
     * QQ互联 APP ID
     */
    @NotBlank(message = "标题不能为空")
    private String appId;
    /**
     * QQ互联 APP Key
     */
    @NotBlank(message = "内容不能为空")
    private String appKey;
    /**
     * QQ互联 成功授权后的回调地址
     */
    private String redirectUri;
}
