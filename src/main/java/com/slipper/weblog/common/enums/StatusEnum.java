package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum StatusEnum implements EnumIntArray {
    DISABLE(0, "禁用"),
    ENABLE(1, "启用"),
    ;
    /**
     * 类型值
     */
    private final Integer code;
    /**
     * 类型名
     */
    private final String message;
    /**
     * 枚举值数组
     */
    public static final int[] ARRAY = Arrays.stream(values()).mapToInt(StatusEnum::getCode).toArray();

    @Override
    public int[] array() {
        return ARRAY;
    }
}
