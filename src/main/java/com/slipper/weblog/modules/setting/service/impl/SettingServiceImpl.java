package com.slipper.weblog.modules.setting.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.core.validator.ValidatorUtils;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.mapper.SettingMapper;
import com.slipper.weblog.modules.setting.model.SettingValue;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateReqVO;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gumingchen
 */
@Service("settingService")
public class SettingServiceImpl extends ServiceImpl<SettingMapper, SettingEntity> implements SettingService {

    @Override
    public void update(List<SettingUpdateReqVO> list) {
        List<SettingEntity> settingEntityList = new ArrayList<>();
        for (SettingUpdateReqVO reqVO : list) {
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
}
