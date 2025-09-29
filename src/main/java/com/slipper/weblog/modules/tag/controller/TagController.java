package com.slipper.weblog.modules.tag.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.TagCreateReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagPageReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateReqVO;
import com.slipper.weblog.modules.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/pass/list")
    public Result<List<TagSelectDTO>> list() {
        return Result.success(
                tagService.querySelectList()
        );
    }

}
