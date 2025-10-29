package com.slipper.weblog.modules.category.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.category.model.vo.CategoryPageVO;
import com.slipper.weblog.modules.category.model.vo.CategoryBaseVO;
import com.slipper.weblog.modules.category.service.CategoryService;
import com.slipper.weblog.modules.category.model.dto.*;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService  categoryService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/page")
    public Result<PageResult<CategoryPageVO>> page(@Validated CategoryPageDTO dto) {
        return Result.success(
                categoryService.page(dto)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated CategoryCreateDTO dto) {
        return Result.success(
                categoryService.create(dto)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated CategoryUpdateDTO dto) {
        categoryService.update(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/sort")
    public Result<?> updateSort(@RequestBody @Validated CategoryUpdateSortDTO dto) {
        categoryService.updateSort(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated CategoryUpdateStatusDTO dto) {
        categoryService.updateStatus(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @Size(min = 1, message = "至少有一个ID") List<Long> ids) {
        categoryService.delete(ids);
        return Result.success();
    }

    @GetMapping("/pass/list")
    public Result<List<CategoryBaseVO>> list() {
        return Result.success(
                categoryService.querySelectList()
        );
    }
}
