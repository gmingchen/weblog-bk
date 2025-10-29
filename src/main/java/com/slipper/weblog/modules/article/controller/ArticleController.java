package com.slipper.weblog.modules.article.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.article.model.dto.ArticleInfoVO;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusDTO;
import com.slipper.weblog.modules.article.service.ArticleService;
import com.slipper.weblog.modules.diary.model.vo.DiaryInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/info")
    public Result<ArticleInfoVO> info(Long id) {
        return Result.success(
                articleService.info(id)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated ArticleCreateDTO dto) {
        ArticleCreateDTO articleCreateReqVO = HttpContextUtils.getObjectBody(ArticleCreateDTO.class);
        return Result.success(
                articleService.create(articleCreateReqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated ArticleUpdateDTO dto) {
        ArticleUpdateDTO articleUpdateReqVO = HttpContextUtils.getObjectBody(ArticleUpdateDTO.class);
        articleService.update(articleUpdateReqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/featured")
    public Result<?> updateFeatured(@RequestBody @Validated ArticleUpdateFeaturedDTO dto) {
        articleService.updateFeatured(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated ArticleUpdateStatusDTO dto) {
        articleService.updateStatus(dto);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @NotNull(message = "ID不能为空") Long id) {
        articleService.delete(id);
        return Result.success();
    }

}
