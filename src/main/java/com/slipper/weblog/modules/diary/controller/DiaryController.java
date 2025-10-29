package com.slipper.weblog.modules.diary.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.diary.model.dto.*;
import com.slipper.weblog.modules.diary.model.vo.*;
import com.slipper.weblog.modules.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/page")
    public Result<PageResult<DiaryPageVO>> page(DiaryPageDTO dto) {
        return Result.success(
                diaryService.page(dto)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/info")
    public Result<DiaryInfoVO> info(Long id) {
        return Result.success(
                diaryService.info(id)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated DiaryCreateDTO dto) {
        DiaryCreateDTO diaryCreateReqVO = HttpContextUtils.getObjectBody(DiaryCreateDTO.class);
        return Result.success(
                diaryService.create(diaryCreateReqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated DiaryUpdateDTO dto) {
        DiaryUpdateDTO diaryUpdateReqVO = HttpContextUtils.getObjectBody(DiaryUpdateDTO.class);
        diaryService.update(diaryUpdateReqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/private")
    public Result<?> updatePrivate(@RequestBody @Validated DiaryUpdatePrivateDTO dto) {
        diaryService.updatePrivate(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated DiaryUpdateStatusDTO dto) {
        diaryService.updateStatus(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @NotNull(message = "ID不能为空") Long id) {
        diaryService.delete(id);
        return Result.success();
    }
}
