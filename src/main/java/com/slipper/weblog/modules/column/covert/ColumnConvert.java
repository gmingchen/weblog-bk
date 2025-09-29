package com.slipper.weblog.modules.column.covert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface ColumnConvert {
    ColumnConvert INSTANCE = Mappers.getMapper(ColumnConvert.class);

}
