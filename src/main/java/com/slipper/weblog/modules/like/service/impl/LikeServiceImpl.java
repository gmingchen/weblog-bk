package com.slipper.weblog.modules.like.service.impl;

import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.like.entity.LikeEntity;
import com.slipper.weblog.modules.like.mapper.LikeMapper;
import com.slipper.weblog.modules.like.service.LikeService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("likeService")
public class LikeServiceImpl extends ServiceImplX<LikeMapper, LikeEntity> implements LikeService {
}
