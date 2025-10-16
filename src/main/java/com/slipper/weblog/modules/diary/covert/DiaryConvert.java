package com.slipper.weblog.modules.diary.covert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface DiaryConvert {
    DiaryConvert INSTANCE = Mappers.getMapper(DiaryConvert.class);
}
