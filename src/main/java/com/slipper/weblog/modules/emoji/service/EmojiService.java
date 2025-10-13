package com.slipper.weblog.modules.emoji.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.model.EmojiDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface EmojiService extends IServiceX<EmojiEntity> {

    List<EmojiDTO> queryList();
}
