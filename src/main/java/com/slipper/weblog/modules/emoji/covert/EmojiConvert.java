package com.slipper.weblog.modules.emoji.covert;

import com.slipper.weblog.modules.emoji.entity.EmojiEntity;
import com.slipper.weblog.modules.emoji.model.EmojiBaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface EmojiConvert {
    EmojiConvert INSTANCE = Mappers.getMapper(EmojiConvert.class);

    EmojiBaseDTO covert(EmojiEntity bean);

    List<EmojiBaseDTO> covert(List<EmojiEntity> list);
}
