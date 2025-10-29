package com.slipper.weblog.modules.setting.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.setting.model.vo.SettingsVO;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateDTO;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/pass/infos")
    public Result<SettingsVO> infos() {
        return Result.success(
                settingService.querySettings()
        );
    }

    @PostMapping("/pass/update")
    public Result<?> update(@RequestBody @Validated List<SettingUpdateDTO> list) {
        list = HttpContextUtils.getListBody(SettingUpdateDTO.class);
        settingService.update(list);
        return Result.success();
    }
}
