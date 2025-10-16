package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum CommentTypeEnum implements EnumIntArray {
    ARTICLE(0, "文章"),
    DIARY(1, "日记"),
    MESSAGE(2, "留言"),
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
    public static final int[] ARRAY = Arrays.stream(values()).mapToInt(CommentTypeEnum::getCode).toArray();

    @Override
    public int[] array() {
        return ARRAY;
    }
}
