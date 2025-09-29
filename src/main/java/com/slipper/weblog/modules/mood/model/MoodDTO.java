package com.slipper.weblog.modules.mood.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MoodDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
}
