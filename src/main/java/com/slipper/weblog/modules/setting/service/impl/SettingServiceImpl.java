package com.slipper.weblog.modules.setting.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.core.validator.ValidatorUtils;
import com.slipper.weblog.modules.setting.config.FileConfig;
import com.slipper.weblog.modules.setting.config.MailConfig;
import com.slipper.weblog.modules.setting.config.QqConfig;
import com.slipper.weblog.modules.setting.covert.SettingConvert;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.mapper.SettingMapper;
import com.slipper.weblog.modules.setting.model.SettingValue;
import com.slipper.weblog.modules.setting.model.dto.*;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateDTO;
import com.slipper.weblog.modules.setting.model.vo.SettingsVO;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("settingService")
public class SettingServiceImpl extends ServiceImplX<SettingMapper, SettingEntity> implements SettingService {

    @Autowired
    private FileConfig fileConfig;
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private QqConfig qqConfig;

    @Override
    public void update(List<SettingUpdateDTO> list) {
        List<SettingEntity> settingEntityList = new ArrayList<>();
        for (SettingUpdateDTO reqVO : list) {
            ValidatorUtils.validate(reqVO);

            for (String key : reqVO.getValue().keySet()) {
                try {
                    reqVO.getValue().put(key, URLDecoder.decode(reqVO.getValue().get(key), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            SettingEnum settingEnum = SettingEnum.getByCode(reqVO.getCode());
            SettingValue settingValue = JSON.parseObject(JSON.toJSONString(reqVO.getValue()), settingEnum.getClazz());
            SettingEntity settingEntity = new SettingEntity()
                    .setCode(reqVO.getCode())
                    .setValue(settingValue);

            SettingEntity setting = this.queryByCode(reqVO.getCode());
            if (setting != null) {
                settingEntity.setId(setting.getId());
            }
            settingEntityList.add(settingEntity);
        }
        this.saveOrUpdateBatch(settingEntityList);
    }

    @Override
    public SettingEntity queryByCode(Integer code) {
        LambdaQueryWrapper<SettingEntity> wrapper = new LambdaQueryWrapper<SettingEntity>()
                .eq(SettingEntity::getCode, code);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public <T> T queryByCode(Integer code, Class<T> clazz) {
        SettingEntity settingEntity = this.queryByCode(code);
        if (settingEntity != null) {
            return JSON.parseObject(JSON.toJSONString(settingEntity.getValue()), clazz);
        }
        return null;
    }

    @Override
    public FileLocalSetting queryFileLocal() {
        FileLocalSetting fileLocalSetting = this.queryByCode(SettingEnum.FILE.getCode(), FileLocalSetting.class);
        if (fileLocalSetting == null) {
            return SettingConvert.INSTANCE.convert(fileConfig);
        }
        return fileLocalSetting;
    }

    @Override
    public EmailSetting queryEmail() {
        EmailSetting emailSetting = this.queryByCode(SettingEnum.EMAIL.getCode(), EmailSetting.class);
        if (emailSetting == null) {
            return SettingConvert.INSTANCE.convert(mailConfig);
        }
        return emailSetting;
    }

    @Override
    public EmailCaptchaSetting queryEmailCaptcha() {
        return this.queryByCode(SettingEnum.EMAIL_CAPTCHA.getCode(), EmailCaptchaSetting.class);
    }

    @Override
    public QqSetting queryQq() {
        QqSetting qqSetting = this.queryByCode(SettingEnum.EMAIL.getCode(), QqSetting.class);
        if (qqSetting == null) {
            return SettingConvert.INSTANCE.convert(qqConfig);
        }
        return qqSetting;
    }

    @Override
    public SettingsVO querySettings() {
        SettingsVO settingsDTO = new SettingsVO();
        QqSetting qqSetting = this.queryByCode(SettingEnum.QQ.getCode(), QqSetting.class);
        if (qqSetting != null) {
            settingsDTO.setQqSetting(
                    SettingConvert.INSTANCE.convert(qqSetting)
            );
        }
        return settingsDTO;
    }
}
