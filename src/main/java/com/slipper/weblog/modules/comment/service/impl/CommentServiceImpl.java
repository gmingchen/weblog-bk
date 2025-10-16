package com.slipper.weblog.modules.comment.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.comment.entity.CommentEntity;
import com.slipper.weblog.modules.comment.mapper.CommentMapper;
import com.slipper.weblog.modules.comment.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImplX<CommentMapper, CommentEntity> implements CommentService {
}
