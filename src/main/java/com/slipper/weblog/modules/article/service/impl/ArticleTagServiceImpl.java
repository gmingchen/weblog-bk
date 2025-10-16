package com.slipper.weblog.modules.article.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.article.entity.ArticleTagEntity;
import com.slipper.weblog.modules.article.mapper.ArticleTagMapper;
import com.slipper.weblog.modules.article.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImplX<ArticleTagMapper, ArticleTagEntity> implements ArticleTagService {
}
