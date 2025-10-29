package com.slipper.weblog.modules.article.covert;

import com.slipper.weblog.modules.article.entity.ArticleEntity;
import com.slipper.weblog.modules.article.model.vo.ArticleCreateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateFeaturedDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateDTO;
import com.slipper.weblog.modules.article.model.vo.ArticleUpdateStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface ArticleConvert {
    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    ArticleEntity convert(ArticleCreateDTO bean);

    ArticleEntity convert(ArticleUpdateDTO bean);

    ArticleEntity convert(ArticleUpdateFeaturedDTO bean);

    ArticleEntity convert(ArticleUpdateStatusDTO bean);
}
