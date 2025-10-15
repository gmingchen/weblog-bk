package com.slipper.weblog.modules.setting.service;

import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.setting.entity.SettingEntity;
import com.slipper.weblog.modules.setting.model.dto.*;
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

    /**
     * 通过Code编码查询配置
     * @param code 编码
     * @param clazz 类
     * @param <T>
     * @return
     */
    <T> T queryByCode(Integer code, Class<T> clazz);

    /**
     * 获取文件存储配置
     * @return
     */
    FileLocalSetting queryFileLocal();

    /**
     * 获取邮箱配置
     * @return
     */
    EmailSetting queryEmail();

    /**
     * 获取邮箱验证码配置
     * @return
     */
    EmailCaptchaSetting queryEmailCaptcha();

    /**
     * 获取QQ配置
     * @return
     */
    QqSetting queryQq();

    /**
     * 获取配置
     * @return
     */
    SettingsDTO querySettings();
}
