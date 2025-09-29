package com.slipper.weblog.modules.emoji.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.model.EmojiDTO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface EmojiService extends IService<EmojiEntity> {

    List<EmojiDTO> queryList();
}
