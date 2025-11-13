package com.slipper.weblog.common.enums;

import cn.hutool.core.util.ArrayUtil;
import com.slipper.weblog.modules.setting.model.SettingValue;
import com.slipper.weblog.modules.setting.model.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum SettingEnum implements EnumIntArray {
    FILE(1, FileLocalSetting.class),
    EMAIL(2, EmailSetting.class),
    EMAIL_CAPTCHA(3, EmailCaptchaSetting.class),
    QQ(4, QqSetting.class),
    WEBSITE(5, WebsiteSetting.class),
    ;
    /**
     * key
     */
    private final Integer code;
    /**
     * 类
     */
    private final Class<? extends SettingValue> clazz;

    /**
     * 枚举值数组
     */
    public static final int[] ARRAY = Arrays.stream(values()).mapToInt(SettingEnum::getCode).toArray();

    @Override
    public int[] array() {
        return ARRAY;
    }

    public static SettingEnum getByCode(Integer code) {
        return ArrayUtil.firstMatch(obj -> obj.getCode().equals(code), values());
    }
}
