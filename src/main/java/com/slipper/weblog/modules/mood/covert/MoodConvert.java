package com.slipper.weblog.modules.mood.covert;

import com.slipper.weblog.modules.mood.entity.MoodEntity;
import com.slipper.weblog.modules.mood.model.MoodBaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface MoodConvert {
    MoodConvert INSTANCE = Mappers.getMapper(MoodConvert.class);

    MoodBaseDTO covert(MoodEntity bean);

    List<MoodBaseDTO> covert(List<MoodEntity> list);
}
