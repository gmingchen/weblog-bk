package com.slipper.weblog.modules.setting.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateReqVO;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PostMapping("/pass/update")
    public Result<?> update(@RequestBody List<SettingUpdateReqVO> list) {
        settingService.update(list);
        return Result.success();
    }
}
