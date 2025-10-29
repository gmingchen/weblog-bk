package com.slipper.weblog.modules.weather.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.modules.weather.covert.WeatherConvert;
import com.slipper.weblog.modules.weather.entity.WeatherEntity;
import com.slipper.weblog.modules.weather.mapper.WeatherMapper;
import com.slipper.weblog.modules.weather.model.WeatherBaseDTO;
import com.slipper.weblog.modules.weather.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("weatherService")
public class WeatherServiceImpl extends ServiceImplX<WeatherMapper, WeatherEntity> implements WeatherService {

    @Override
    public List<WeatherBaseDTO> queryList() {
        LambdaQueryWrapper<WeatherEntity> wrapper = new LambdaQueryWrapper<WeatherEntity>()
                .eq(WeatherEntity::getStatus, StatusEnum.ENABLE.getCode());
        return WeatherConvert.INSTANCE.covert(baseMapper.selectList(wrapper));
    }
}
