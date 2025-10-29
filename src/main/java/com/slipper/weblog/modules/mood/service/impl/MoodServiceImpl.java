package com.slipper.weblog.modules.mood.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.modules.mood.covert.MoodConvert;
import com.slipper.weblog.modules.mood.entity.MoodEntity;
import com.slipper.weblog.modules.mood.mapper.MoodMapper;
import com.slipper.weblog.modules.mood.model.MoodBaseDTO;
import com.slipper.weblog.modules.mood.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("moodService")
public class MoodServiceImpl extends ServiceImplX<MoodMapper, MoodEntity> implements MoodService {

    @Override
    public List<MoodBaseDTO> queryList() {
        LambdaQueryWrapper<MoodEntity> wrapper = new LambdaQueryWrapper<MoodEntity>()
                .eq(MoodEntity::getStatus, StatusEnum.ENABLE.getCode());
        return MoodConvert.INSTANCE.covert(baseMapper.selectList(wrapper));
    }
}
