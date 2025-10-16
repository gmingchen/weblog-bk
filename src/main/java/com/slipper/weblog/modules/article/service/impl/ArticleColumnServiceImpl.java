package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.article.entity.ArticleColumnEntity;
import com.slipper.weblog.modules.article.mapper.ArticleColumnMapper;
import com.slipper.weblog.modules.article.service.ArticleColumnService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("articleColumnService")
public class ArticleColumnServiceImpl extends ServiceImplX<ArticleColumnMapper, ArticleColumnEntity> implements ArticleColumnService {
}
