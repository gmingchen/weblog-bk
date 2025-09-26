package com.slipper.weblog.modules.token.covert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface TokenConvert {
    TokenConvert INSTANCE = Mappers.getMapper(TokenConvert.class);
}
