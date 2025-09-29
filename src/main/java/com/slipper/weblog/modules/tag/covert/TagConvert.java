package com.slipper.weblog.modules.tag.covert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.model.dto.TagPageDTO;
import com.slipper.weblog.modules.tag.model.dto.TagSelectDTO;
import com.slipper.weblog.modules.tag.model.vo.TagCreateReqVO;
import com.slipper.weblog.modules.tag.model.vo.TagUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface TagConvert {
    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagPageDTO covertPage(TagEntity bean);
    PageResult<TagPageDTO> convert(PageResult<TagEntity> bean);

    TagEntity convert(TagCreateReqVO bean);

    TagEntity convert(TagUpdateReqVO bean);

    TagSelectDTO covertSelect(TagEntity bean);
    List<TagSelectDTO> covertSelect(List<TagEntity> list);

}
