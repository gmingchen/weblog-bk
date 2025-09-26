package com.slipper.weblog.modules.setting.covert;

import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface SettingConvert {
    SettingConvert INSTANCE = Mappers.getMapper(SettingConvert.class);
}
