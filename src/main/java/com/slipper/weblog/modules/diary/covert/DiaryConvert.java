package com.slipper.weblog.modules.diary.covert;

import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.model.vo.DiaryCreateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateReqVO;
import com.slipper.weblog.modules.diary.model.vo.DiaryUpdateStatusReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface DiaryConvert {
    DiaryConvert INSTANCE = Mappers.getMapper(DiaryConvert.class);

    DiaryEntity convert(DiaryCreateReqVO bean);

    DiaryEntity convert(DiaryUpdateReqVO bean);

    DiaryEntity convert(DiaryUpdateStatusReqVO bean);
}
