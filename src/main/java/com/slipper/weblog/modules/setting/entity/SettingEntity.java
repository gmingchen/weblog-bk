package com.slipper.weblog.modules.setting.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.slipper.weblog.common.entity.BaseEntity;
import com.slipper.weblog.modules.setting.model.SettingValue;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 系统设置
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName(value = "setting", autoResultMap = true)
public class SettingEntity extends BaseEntity {
    /**
     * 配置项编码
     */
    @TableField("code")
    private Integer code;
    /**
     * 配置项值
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private SettingValue value;
}
