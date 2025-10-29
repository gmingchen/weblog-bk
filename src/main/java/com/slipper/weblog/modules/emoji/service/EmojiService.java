package com.slipper.weblog.modules.emoji.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.model.EmojiBaseDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface EmojiService extends IServiceX<EmojiEntity> {

    List<EmojiBaseDTO> queryList();
}
