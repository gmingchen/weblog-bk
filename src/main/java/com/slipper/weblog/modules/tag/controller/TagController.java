package com.slipper.weblog.modules.tag.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.*;
import com.slipper.weblog.modules.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/page")
    public Result<PageResult<TagPageDTO>> page(@Validated TagPageReqVO reqVO) {
        return Result.success(
                tagService.page(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated TagCreateReqVO reqVO) {
        return Result.success(
                tagService.create(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated TagUpdateReqVO reqVO) {
        tagService.update(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/sort")
    public Result<?> updateSort(@RequestBody @Validated TagUpdateSortReqVO reqVO) {
        tagService.updateSort(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated TagUpdateStatusReqVO reqVO) {
        tagService.updateStatus(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Size(min = 1, message = "至少有一个ID") List<Long> ids) {
        tagService.delete(ids);
        return Result.success();
    }

    @GetMapping("/pass/list")
    public Result<List<TagSelectDTO>> list() {
        return Result.success(
                tagService.querySelectList()
        );
    }

}
