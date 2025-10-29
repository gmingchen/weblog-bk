package com.slipper.weblog.modules.article.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.model.dto.ArticleInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author gumingchen
 */
@Mapper
public interface ArticleMapper extends BaseMapperX<ArticleEntity> {

    ArticleInfoVO queryInfo(@Param("id") Long id);
}
