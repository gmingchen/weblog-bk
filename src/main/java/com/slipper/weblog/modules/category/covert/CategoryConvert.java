package com.slipper.weblog.modules.category.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.category.entity.CategoryEntity;
import com.slipper.weblog.modules.category.model.dto.CategoryPageDTO;
import com.slipper.weblog.modules.category.model.dto.CategorySelectDTO;
import com.slipper.weblog.modules.category.model.vo.CategoryCreateReqVO;
import com.slipper.weblog.modules.category.model.vo.CategoryUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    CategoryPageDTO covertPage(CategoryEntity bean);
    PageResult<CategoryPageDTO> convert(PageResult<CategoryEntity> bean);

    CategoryEntity convert(CategoryCreateReqVO bean);

    CategoryEntity convert(CategoryUpdateReqVO bean);

    CategorySelectDTO covertSelect(CategoryEntity bean);
    List<CategorySelectDTO> covertSelect(List<CategoryEntity> list);

}
