package com.slipper.weblog.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 天气
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("weather")
public class WeatherEntity extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
