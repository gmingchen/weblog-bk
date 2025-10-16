package com.slipper.weblog.modules.comment.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.comment.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface CommentMapper extends BaseMapperX<CommentEntity> {
}
