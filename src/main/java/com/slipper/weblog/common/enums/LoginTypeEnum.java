package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum implements EnumIntArray {
    /**
     * 登录类型
     */
    EMAIL(1, "邮箱登录"),
    QQ(2, "QQ登录"),
    ;
    /**
     * 类型名
     */
    private final Integer code;
    /**
     * 信息
     */
    private final String message;

    /**
     * 枚举值数组
     */
    public static final int[] ARRAY = Arrays.stream(values()).mapToInt(LoginTypeEnum::getCode).toArray();

    @Override
    public int[] array() {
        return ARRAY;
    }
}
