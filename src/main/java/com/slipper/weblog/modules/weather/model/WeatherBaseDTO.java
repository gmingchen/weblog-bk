package com.slipper.weblog.modules.weather.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class WeatherBaseDTO {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
}
