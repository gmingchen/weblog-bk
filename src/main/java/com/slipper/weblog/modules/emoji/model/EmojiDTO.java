package com.slipper.weblog.modules.emoji.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class EmojiDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
}
