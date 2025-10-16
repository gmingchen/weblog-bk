package com.slipper.weblog.modules.like.covert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface LikeConvert {
    LikeConvert INSTANCE = Mappers.getMapper(LikeConvert.class);
}
