package com.slipper.weblog.modules.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import com.slipper.weblog.modules.weather.model.WeatherDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface WeatherService extends IService<WeatherEntity> {

    List<WeatherDTO> queryList();
}
