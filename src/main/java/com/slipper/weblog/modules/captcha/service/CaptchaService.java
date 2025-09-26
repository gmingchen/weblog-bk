package com.slipper.weblog.modules.captcha.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;

/**
 * @author gumingchen
 */
public interface CaptchaService extends IService<CaptchaEntity> {
    /**
     * 新增验证码
     * @param uuid UUID
     * @return
     */
    CaptchaEntity create(String uuid);
}
