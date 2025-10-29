package com.slipper.weblog.modules.setting.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class QqSettingVO {
    /**
     * QQ互联 APP ID
     */
    private String appId;
    /**
     * QQ互联 成功授权后的回调地址
     */
    private String redirectUri;
}
