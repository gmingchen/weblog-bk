package com.slipper.weblog.modules.tag.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import com.slipper.weblog.modules.tag.model.dto.TagCreateDTO;
import com.slipper.weblog.modules.tag.model.dto.TagUpdateDTO;
import com.slipper.weblog.modules.tag.model.vo.TagBaseVO;
import com.slipper.weblog.modules.tag.model.vo.TagPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface TagConvert {
    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagPageVO covertPage(TagEntity bean);
    PageResult<TagPageVO> convert(PageResult<TagEntity> bean);

    TagEntity convert(TagCreateDTO bean);

    TagEntity convert(TagUpdateDTO bean);

    TagBaseVO covertSelect(TagEntity bean);
    List<TagBaseVO> covertSelect(List<TagEntity> list);

}
