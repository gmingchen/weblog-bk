package com.slipper.weblog.modules.mood.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.mood.model.MoodDTO;
import com.slipper.weblog.modules.mood.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @GetMapping("/pass/list")
    public Result<List<MoodDTO>> getList() {
        return Result.success(
                moodService.queryList()
        );
    }
}
