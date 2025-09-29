package com.slipper.weblog.modules.tag.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.tag.entity.TagEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface TagMapper extends BaseMapperX<TagEntity> {
}
