package com.slipper.weblog.modules.captcha.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;

/**
 * @author gumingchen
 */
public interface CaptchaService extends IServiceX<CaptchaEntity> {
    /**
     * 新增验证码
     * @param uuid UUID
     * @return
     */
    CaptchaEntity create(String uuid);

    /**
     * 刪除
     * @param uuid UUID
     */
    void deleteByUuid(String uuid);

    /**
     * 验证验证码
     * @param uuid UUID
     * @param captcha 验证码
     * @return
     */
    Boolean validate(String uuid, String captcha);
}
