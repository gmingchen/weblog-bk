package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.article.covert.ArticleConvert;
import com.slipper.weblog.modules.article.entity.ArticleCategoryEntity;
import com.slipper.weblog.modules.article.entity.ArticleColumnEntity;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.entity.ArticleTagEntity;
import com.slipper.weblog.modules.article.mapper.ArticleMapper;
import com.slipper.weblog.modules.article.model.dto.ArticleInfoVO;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusDTO;
import com.slipper.weblog.modules.article.service.ArticleCategoryService;
import com.slipper.weblog.modules.article.service.ArticleColumnService;
import com.slipper.weblog.modules.article.service.ArticleService;
import com.slipper.weblog.modules.article.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gumingchen
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImplX<ArticleMapper, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private ArticleColumnService articleColumnService;

    @Override
    public ArticleInfoVO info(Long id) {
        return baseMapper.queryInfo(id);
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public Long create(ArticleCreateDTO dto) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(dto);
        baseMapper.insert(articleEntity);

        articleCategoryService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleCategoryEntity::getArticleId,
                ArticleCategoryEntity::getCategoryId,
                id -> new ArticleCategoryEntity().setArticleId(articleEntity.getId()).setCategoryId((Long) id),
                ArticleCategoryEntity::getCategoryId
        );

        articleTagService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleTagEntity::getArticleId,
                ArticleTagEntity::getTagId,
                id -> new ArticleTagEntity().setArticleId(articleEntity.getId()).setTagId((Long) id),
                ArticleTagEntity::getTagId
        );

        articleColumnService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleColumnEntity::getArticleId,
                ArticleColumnEntity::getColumnId,
                id -> new ArticleColumnEntity().setArticleId(articleEntity.getId()).setColumnId((Long) id),
                ArticleColumnEntity::getColumnId
        );

        return articleEntity.getId();
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public void update(ArticleUpdateDTO dto) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(dto);
        baseMapper.updateById(articleEntity);

        articleCategoryService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleCategoryEntity::getArticleId,
                ArticleCategoryEntity::getCategoryId,
                id -> new ArticleCategoryEntity().setArticleId(articleEntity.getId()).setCategoryId((Long) id),
                ArticleCategoryEntity::getCategoryId
        );

        articleTagService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleTagEntity::getArticleId,
                ArticleTagEntity::getTagId,
                id -> new ArticleTagEntity().setArticleId(articleEntity.getId()).setTagId((Long) id),
                ArticleTagEntity::getTagId
        );

        articleColumnService.saveOrRemoveBatch(
                articleEntity.getId(),
                dto.getCategoryIds(),
                ArticleColumnEntity::getArticleId,
                ArticleColumnEntity::getColumnId,
                id -> new ArticleColumnEntity().setArticleId(articleEntity.getId()).setColumnId((Long) id),
                ArticleColumnEntity::getColumnId
        );
    }

    @Override
    public void updateFeatured(ArticleUpdateFeaturedDTO dto) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(dto);
        baseMapper.updateById(articleEntity);
    }

    @Override
    public void updateStatus(ArticleUpdateStatusDTO dto) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(dto);
        baseMapper.updateById(articleEntity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

}
