package com.slipper.weblog.modules.captcha.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.common.enums.ResultCodeEnum;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.captcha.entity.CaptchaEntity;
import com.slipper.weblog.modules.captcha.mapper.CaptchaMapper;
import com.slipper.weblog.modules.captcha.service.CaptchaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * @author gumingchen
 */
@Service("captchaService")
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, CaptchaEntity> implements CaptchaService {

    public static final long DURATION = 60 * 5;

    @Override
    public CaptchaEntity create(String uuid) {
        String captcha = RandomUtil.randomStringUpper(6);

        CaptchaEntity captchaEntity = this.getByUuid(uuid);
        if (captchaEntity != null) {
            throw new RunException(ResultCodeEnum.CAPTCHA_EXIST_ERROR);
        }

        captchaEntity = new CaptchaEntity()
                .setUuid(uuid)
                .setCode(captcha)
                .setExpireAt(LocalDateTime.now().plusSeconds(DURATION));
        baseMapper.insert(captchaEntity);

        return captchaEntity;
    }

    @Override
    public void deleteByUuid(String uuid) {
        baseMapper.deleteByUuid(uuid);
//        LambdaQueryWrapper<CaptchaEntity> wrapper = new LambdaQueryWrapper<CaptchaEntity>()
//                .eq(CaptchaEntity::getUuid, uuid);
//        baseMapper.delete(wrapper);
    }

    @Override
    public Boolean validate(String uuid, String captcha) {
        CaptchaEntity captchaEntity = this.getByUuid(uuid);

        return Optional.ofNullable(captchaEntity)
                .map(w -> Objects.equals(w.getCode(), captcha))
                .orElse(false);
    }


    private CaptchaEntity getByUuid(String uuid) {
        LambdaQueryWrapper<CaptchaEntity> wrapper = new LambdaQueryWrapper<CaptchaEntity>()
                .eq(CaptchaEntity::getUuid, uuid)
                .ge(CaptchaEntity::getExpireAt, LocalDateTime.now());
        return baseMapper.selectOne(wrapper);
    }
}
