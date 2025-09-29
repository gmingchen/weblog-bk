package com.slipper.weblog.modules.weather.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class WeatherDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
}
