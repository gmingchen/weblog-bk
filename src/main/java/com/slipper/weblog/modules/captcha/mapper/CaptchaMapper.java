package com.slipper.weblog.modules.captcha.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface CaptchaMapper extends BaseMapperX<CaptchaEntity> {

    /**
     * 删除
     * @param uuid UUID
     */
    @Delete("DELETE FROM captcha WHERE uuid = #{uuid}")
    void deleteByUuid(String uuid);
}
