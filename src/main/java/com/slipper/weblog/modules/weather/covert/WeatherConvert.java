package com.slipper.weblog.modules.weather.covert;

import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import com.slipper.weblog.modules.weather.model.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface WeatherConvert {
    WeatherConvert INSTANCE = Mappers.getMapper(WeatherConvert.class);

    WeatherDTO covert(WeatherEntity bean);

    List<WeatherDTO> covert(List<WeatherEntity> list);
}
