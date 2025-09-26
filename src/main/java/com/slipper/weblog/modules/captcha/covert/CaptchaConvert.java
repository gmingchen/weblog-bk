package com.slipper.weblog.modules.captcha.covert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface CaptchaConvert {
    CaptchaConvert INSTANCE = Mappers.getMapper(CaptchaConvert.class);
}
