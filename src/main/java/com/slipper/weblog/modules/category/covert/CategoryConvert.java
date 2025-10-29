package com.slipper.weblog.modules.category.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.model.vo.CategoryPageVO;
import com.slipper.weblog.modules.category.model.vo.CategoryBaseVO;
import com.slipper.weblog.modules.category.model.dto.CategoryCreateDTO;
import com.slipper.weblog.modules.category.model.dto.CategoryUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    CategoryPageVO covertPage(CategoryEntity bean);
    PageResult<CategoryPageVO> convert(PageResult<CategoryEntity> bean);

    CategoryEntity convert(CategoryCreateDTO bean);

    CategoryEntity convert(CategoryUpdateDTO bean);

    CategoryBaseVO covertSelect(CategoryEntity bean);
    List<CategoryBaseVO> covertSelect(List<CategoryEntity> list);

}
