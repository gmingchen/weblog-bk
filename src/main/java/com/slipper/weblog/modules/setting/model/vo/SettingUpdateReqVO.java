package com.slipper.weblog.modules.setting.model.vo;

import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * @author gumingchen
 */
@Data
public class SettingUpdateReqVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 配置项编码
     */
    @Enum(SettingEnum.class)
    @NotNull(message = "配置项编码不能为空")
    private Integer code;
    /**
     * 配置项值
     */
    @NotNull(message = "配置项值不能为空")
    private Map<String, String> value;
}
