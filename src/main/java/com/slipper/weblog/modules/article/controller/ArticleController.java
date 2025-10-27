package com.slipper.weblog.modules.article.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusReqVO;
import com.slipper.weblog.modules.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/create")
    public Result<Long> create(@RequestBody @Validated ArticleCreateReqVO reqVO) {
        ArticleCreateReqVO articleCreateReqVO = HttpContextUtils.getObjectBody(ArticleCreateReqVO.class);
        return Result.success(
                articleService.create(articleCreateReqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update")
    public Result<?> update(@RequestBody @Validated ArticleUpdateReqVO reqVO) {
        ArticleUpdateReqVO articleUpdateReqVO = HttpContextUtils.getObjectBody(ArticleUpdateReqVO.class);
        articleService.update(articleUpdateReqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/featured")
    public Result<?> updateFeatured(@RequestBody @Validated ArticleUpdateFeaturedReqVO reqVO) {
        articleService.updateFeatured(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStatus(@RequestBody @Validated ArticleUpdateStatusReqVO reqVO) {
        articleService.updateStatus(reqVO);
        return Result.success();
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody @NotNull(message = "ID不能为空") Long id) {
        articleService.delete(id);
        return Result.success();
    }

}
