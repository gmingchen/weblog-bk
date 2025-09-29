package com.slipper.weblog.modules.mood.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.modules.mood.covert.MoodConvert;
import com.slipper.weblog.modules.mood.entity.MoodEntity;
import com.slipper.weblog.modules.mood.mapper.MoodMapper;
import com.slipper.weblog.modules.mood.model.MoodDTO;
import com.slipper.weblog.modules.mood.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("moodService")
public class MoodServiceImpl extends ServiceImpl<MoodMapper, MoodEntity> implements MoodService {

    @Override
    public List<MoodDTO> queryList() {
        LambdaQueryWrapper<MoodEntity> wrapper = new LambdaQueryWrapper<MoodEntity>()
                .eq(MoodEntity::getStatus, StatusEnum.ENABLE.getCode());
        return MoodConvert.INSTANCE.covert(baseMapper.selectList(wrapper));
    }
}
