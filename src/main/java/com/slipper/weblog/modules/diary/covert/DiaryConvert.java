package com.slipper.weblog.modules.diary.covert;

import com.slipper.weblog.modules.diary.entity.DiaryEntity;
import com.slipper.weblog.modules.diary.model.dto.DiaryCreateDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryUpdatePrivateDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryUpdateDTO;
import com.slipper.weblog.modules.diary.model.dto.DiaryUpdateStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface DiaryConvert {
    DiaryConvert INSTANCE = Mappers.getMapper(DiaryConvert.class);

    DiaryEntity convert(DiaryCreateDTO bean);

    DiaryEntity convert(DiaryUpdateDTO bean);

    DiaryEntity convert(DiaryUpdatePrivateDTO bean);

    DiaryEntity convert(DiaryUpdateStatusDTO bean);
}
