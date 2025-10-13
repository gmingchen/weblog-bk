package com.slipper.weblog.modules.column.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.column.service.ColumnService;
import com.slipper.weblog.modules.column.model.dto.ColumnPageDTO;
import com.slipper.weblog.modules.column.model.dto.ColumnSelectDTO;
import com.slipper.weblog.modules.column.model.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/page")
    public Result<PageResult<ColumnPageDTO>> page(@Validated ColumnPageReqVO reqVO) {
        return Result.success(
                columnService.page(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated ColumnCreateReqVO reqVO) {
        return Result.success(
                columnService.create(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated ColumnUpdateReqVO reqVO) {
        columnService.update(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/sort")
    public Result<?> updateSort(@RequestBody @Validated ColumnUpdateSortReqVO reqVO) {
        columnService.updateSort(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated ColumnUpdateStatusReqVO reqVO) {
        columnService.updateStatus(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Size(min = 1, message = "至少有一个ID") List<Long> ids) {
        columnService.delete(ids);
        return Result.success();
    }

    @GetMapping("/pass/list")
    public Result<List<ColumnSelectDTO>> list() {
        return Result.success(
                columnService.querySelectList()
        );
    }
}
