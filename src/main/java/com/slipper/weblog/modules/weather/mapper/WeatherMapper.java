package com.slipper.weblog.modules.weather.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface WeatherMapper extends BaseMapperX<WeatherEntity> {
}
