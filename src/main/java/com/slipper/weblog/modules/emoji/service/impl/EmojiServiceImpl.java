package com.slipper.weblog.modules.emoji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.modules.emoji.covert.EmojiConvert;
import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.mapper.EmojiMapper;
import com.slipper.weblog.modules.emoji.model.EmojiBaseDTO;
import com.slipper.weblog.modules.emoji.service.EmojiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("emojiService")
public class EmojiServiceImpl extends ServiceImplX<EmojiMapper, EmojiEntity> implements EmojiService {

    @Override
    public List<EmojiBaseDTO> queryList() {
        LambdaQueryWrapper<EmojiEntity> wrapper = new LambdaQueryWrapper<EmojiEntity>()
                .eq(EmojiEntity::getStatus, StatusEnum.ENABLE.getCode());
        return EmojiConvert.INSTANCE.covert(baseMapper.selectList(wrapper));
    }
}
