package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.article.entity.ArticleCategoryEntity;
import com.slipper.weblog.modules.article.mapper.ArticleCategoryMapper;
import com.slipper.weblog.modules.article.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("articleCategoryService")
public class ArticleCategoryServiceImpl extends ServiceImplX<ArticleCategoryMapper, ArticleCategoryEntity> implements ArticleCategoryService {
}
