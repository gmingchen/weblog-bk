package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.mapper.ArticleMapper;
import com.slipper.weblog.modules.article.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImplX<ArticleMapper, ArticleEntity> implements ArticleService {
}
