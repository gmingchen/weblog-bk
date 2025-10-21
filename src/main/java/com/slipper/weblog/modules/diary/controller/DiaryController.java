package com.slipper.weblog.modules.diary.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.diary.model.dto.DiaryInfoDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryPageDTO;
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
    public Result<PageResult<DiaryPageDTO>> page(DiaryPageReqVO reqVO) {
        return Result.success(
                diaryService.page(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/info")
    public Result<DiaryInfoDTO> info(Long id) {
        return Result.success(
                diaryService.info(id)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated DiaryCreateReqVO reqVO) {
        reqVO = HttpContextUtils.getObjectBody(DiaryCreateReqVO.class);
        return Result.success(
                diaryService.create(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated DiaryUpdateReqVO reqVO) {
        reqVO = HttpContextUtils.getObjectBody(DiaryUpdateReqVO.class);
        diaryService.update(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/private")
    public Result<?> updatePrivate(@RequestBody @Validated DiaryUpdatePrivateReqVO reqVO) {
        diaryService.updatePrivate(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated DiaryUpdateStatusReqVO reqVO) {
        diaryService.updateStatus(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @NotNull(message = "ID不能为空") Long id) {
        diaryService.delete(id);
        return Result.success();
    }
}
