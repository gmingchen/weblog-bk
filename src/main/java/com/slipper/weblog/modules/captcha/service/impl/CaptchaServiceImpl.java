package com.slipper.weblog.modules.captcha.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import com.slipper.weblog.modules.captcha.mapper.CaptchaMapper;
import com.slipper.weblog.modules.captcha.service.CaptchaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Service("captchaService")
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, CaptchaEntity> implements CaptchaService {

    public static final long DURATION = 60 * 5;

    @Override
    public CaptchaEntity create(String uuid) {
        String captcha = RandomUtil.randomStringUpper(6);

        CaptchaEntity captchaEntity = new CaptchaEntity()
                .setUuid(uuid)
                .setCode(captcha)
                .setExpireAt(LocalDateTime.now().plusSeconds(DURATION));
        baseMapper.insert(captchaEntity);

        return captchaEntity;
    }
}
