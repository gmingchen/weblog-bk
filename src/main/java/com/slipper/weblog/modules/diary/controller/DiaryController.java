package com.slipper.weblog.modules.diary.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.diary.model.vo.DiaryCreateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateStatusReqVO;
import com.slipper.weblog.modules.diary.service.DiaryService;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateSortReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateStatusReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated DiaryCreateReqVO reqVO) {
        return Result.success(
                diaryService.create(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated DiaryUpdateReqVO reqVO) {
        diaryService.update(reqVO);
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
