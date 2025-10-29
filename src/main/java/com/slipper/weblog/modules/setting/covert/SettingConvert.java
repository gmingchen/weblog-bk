package com.slipper.weblog.modules.setting.covert;

import com.slipper.weblog.modules.setting.config.FileConfig;
import com.slipper.weblog.modules.setting.config.MailConfig;
import com.slipper.weblog.modules.setting.config.QqConfig;
import com.slipper.weblog.modules.setting.model.dto.*;
import com.slipper.weblog.modules.setting.model.vo.QqSettingVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface SettingConvert {
    SettingConvert INSTANCE = Mappers.getMapper(SettingConvert.class);

    FileLocalSetting convert(FileConfig bean);
    EmailSetting convert(MailConfig bean);
    QqSetting convert(QqConfig bean);

    QqSettingVO convert(QqSetting bean);
}
