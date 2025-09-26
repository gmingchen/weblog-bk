package com.slipper.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gumingchen
 */
@Getter
@AllArgsConstructor
public enum MediaTypeEnum {
    /**
     * 媒体类型
     */
    JSON_UTF8("application/json;charset=UTF-8"),
    ;
    /**
     * 类型名
     */
    private final String value;
}
