package com.slipper.weblog.modules.weather.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import com.slipper.weblog.modules.weather.model.WeatherBaseDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface WeatherService extends IServiceX<WeatherEntity> {

    /**
     * 列表
     * @return
     */
    List<WeatherBaseDTO> queryList();
}
