package com.slipper.weblog.modules.column.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.column.entity.ColumnEntity;
import com.slipper.weblog.modules.column.model.dto.ColumnPageDTO;
import com.slipper.weblog.modules.column.model.dto.ColumnSelectDTO;
import com.slipper.weblog.modules.column.model.vo.ColumnCreateReqVO;
import com.slipper.weblog.modules.column.model.vo.ColumnUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface ColumnConvert {
    ColumnConvert INSTANCE = Mappers.getMapper(ColumnConvert.class);
    
    ColumnPageDTO covertPage(ColumnEntity bean);
    PageResult<ColumnPageDTO> convert(PageResult<ColumnEntity> bean);

    ColumnEntity convert(ColumnCreateReqVO bean);

    ColumnEntity convert(ColumnUpdateReqVO bean);

    ColumnSelectDTO covertSelect(ColumnEntity bean);
    List<ColumnSelectDTO> covertSelect(List<ColumnEntity> list);

}
