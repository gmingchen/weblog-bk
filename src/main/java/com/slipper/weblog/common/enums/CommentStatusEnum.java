package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum CommentStatusEnum implements EnumIntArray {
    PENDING(0, "待审核"),
    PASS(1, "通过"),
    REJECT(2, "驳回"),
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
    public static final int[] ARRAY = Arrays.stream(values()).mapToInt(CommentStatusEnum::getCode).toArray();

    @Override
    public int[] array() {
        return ARRAY;
    }
}
