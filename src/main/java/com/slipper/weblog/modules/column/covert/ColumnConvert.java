package com.slipper.weblog.modules.column.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.model.vo.ColumnPageVO;
import com.slipper.weblog.modules.column.model.vo.ColumnBaseVO;
import com.slipper.weblog.modules.column.model.dto.ColumnCreateDTO;
import com.slipper.weblog.modules.column.model.dto.ColumnUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface ColumnConvert {
    ColumnConvert INSTANCE = Mappers.getMapper(ColumnConvert.class);
    
    ColumnPageVO covertPage(ColumnEntity bean);
    PageResult<ColumnPageVO> convert(PageResult<ColumnEntity> bean);

    ColumnEntity convert(ColumnCreateDTO bean);

    ColumnEntity convert(ColumnUpdateReqVO bean);

    ColumnBaseVO covertSelect(ColumnEntity bean);
    List<ColumnBaseVO> covertSelect(List<ColumnEntity> list);

}
