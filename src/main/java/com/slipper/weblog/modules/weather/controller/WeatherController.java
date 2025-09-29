package com.slipper.weblog.modules.weather.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.weather.model.WeatherDTO;
import com.slipper.weblog.modules.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/pass/list")
    public Result<List<WeatherDTO>> getList() {
        return Result.success(
                weatherService.queryList()
        );
    }
}
