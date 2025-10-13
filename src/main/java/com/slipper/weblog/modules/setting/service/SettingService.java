package com.slipper.weblog.modules.setting.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.model.vo.SettingUpdateReqVO;

import java.util.List;

/**
 * @author gumingchen
 */
public interface SettingService extends IServiceX<SettingEntity> {

    /**
     * 更新配置
     * @param list
     */
    void update(List<SettingUpdateReqVO> list);

    /**
     * 通过Code编码查询配置
     * @param code 编码
     * @return
     */
    SettingEntity queryByCode(Integer code);
}
