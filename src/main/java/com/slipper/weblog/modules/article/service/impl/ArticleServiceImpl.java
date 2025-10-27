package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.article.covert.ArticleConvert;
import com.slipper.weblog.modules.article.entity.ArticleCategoryEntity;
import com.slipper.weblog.modules.article.entity.ArticleColumnEntity;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.entity.ArticleTagEntity;
import com.slipper.weblog.modules.article.mapper.ArticleMapper;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusReqVO;
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

    @Transactional(rollbackFor = RunException.class)
    @Override
    public Long create(ArticleCreateReqVO reqVO) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(reqVO);
        baseMapper.insert(articleEntity);

        articleCategoryService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleCategoryEntity::getArticleId,
                ArticleCategoryEntity::getCategoryId,
                id -> new ArticleCategoryEntity().setArticleId(articleEntity.getId()).setCategoryId((Long) id),
                ArticleCategoryEntity::getCategoryId
        );

        articleTagService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleTagEntity::getArticleId,
                ArticleTagEntity::getTagId,
                id -> new ArticleTagEntity().setArticleId(articleEntity.getId()).setTagId((Long) id),
                ArticleTagEntity::getTagId
        );

        articleColumnService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleColumnEntity::getArticleId,
                ArticleColumnEntity::getColumnId,
                id -> new ArticleColumnEntity().setArticleId(articleEntity.getId()).setColumnId((Long) id),
                ArticleColumnEntity::getColumnId
        );

        return articleEntity.getId();
    }

    @Transactional(rollbackFor = RunException.class)
    @Override
    public void update(ArticleUpdateReqVO reqVO) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(articleEntity);

        articleCategoryService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleCategoryEntity::getArticleId,
                ArticleCategoryEntity::getCategoryId,
                id -> new ArticleCategoryEntity().setArticleId(articleEntity.getId()).setCategoryId((Long) id),
                ArticleCategoryEntity::getCategoryId
        );

        articleTagService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleTagEntity::getArticleId,
                ArticleTagEntity::getTagId,
                id -> new ArticleTagEntity().setArticleId(articleEntity.getId()).setTagId((Long) id),
                ArticleTagEntity::getTagId
        );

        articleColumnService.saveOrRemoveBatch(
                articleEntity.getId(),
                reqVO.getCategoryIds(),
                ArticleColumnEntity::getArticleId,
                ArticleColumnEntity::getColumnId,
                id -> new ArticleColumnEntity().setArticleId(articleEntity.getId()).setColumnId((Long) id),
                ArticleColumnEntity::getColumnId
        );
    }

    @Override
    public void updateFeatured(ArticleUpdateFeaturedReqVO reqVO) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(articleEntity);
    }

    @Override
    public void updateStatus(ArticleUpdateStatusReqVO reqVO) {
        ArticleEntity articleEntity = ArticleConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(articleEntity);
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

}
