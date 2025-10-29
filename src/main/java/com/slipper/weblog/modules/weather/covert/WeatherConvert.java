package com.slipper.weblog.modules.weather.covert;

import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import com.slipper.weblog.modules.weather.model.WeatherBaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface WeatherConvert {
    WeatherConvert INSTANCE = Mappers.getMapper(WeatherConvert.class);

    WeatherBaseDTO covert(WeatherEntity bean);

    List<WeatherBaseDTO> covert(List<WeatherEntity> list);
}
