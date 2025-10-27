package com.slipper.weblog.modules.article.covert;

import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateReqVO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface ArticleConvert {
    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    ArticleEntity convert(ArticleCreateReqVO bean);

    ArticleEntity convert(ArticleUpdateReqVO bean);

    ArticleEntity convert(ArticleUpdateFeaturedReqVO bean);

    ArticleEntity convert(ArticleUpdateStatusReqVO bean);
}
