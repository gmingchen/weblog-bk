package com.slipper.weblog.modules.emoji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.modules.emoji.covert.EmojiConvert;
import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.mapper.EmojiMapper;
import com.slipper.weblog.modules.emoji.model.EmojiDTO;
import com.slipper.weblog.modules.emoji.service.EmojiService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumingchen
 */
@Service("emojiService")
public class EmojiServiceImpl extends ServiceImpl<EmojiMapper, EmojiEntity> implements EmojiService {

    @Override
    public List<EmojiDTO> queryList() {
        LambdaQueryWrapper<EmojiEntity> wrapper = new LambdaQueryWrapper<EmojiEntity>()
                .eq(EmojiEntity::getStatus, StatusEnum.ENABLE.getCode());
        return EmojiConvert.INSTANCE.covert(baseMapper.selectList(wrapper));
    }
}
