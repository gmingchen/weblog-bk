package com.slipper.weblog.modules.captcha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface CaptchaMapper extends BaseMapper<CaptchaEntity> {
}
