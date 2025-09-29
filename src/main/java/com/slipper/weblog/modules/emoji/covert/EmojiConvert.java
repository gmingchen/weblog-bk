package com.slipper.weblog.modules.emoji.covert;

import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.model.EmojiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface EmojiConvert {
    EmojiConvert INSTANCE = Mappers.getMapper(EmojiConvert.class);

    EmojiDTO covert(EmojiEntity bean);

    List<EmojiDTO> covert(List<EmojiEntity> list);
}
