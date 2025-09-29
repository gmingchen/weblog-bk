package com.slipper.weblog.modules.mood.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 心情
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("mood")
public class MoodEntity extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * emoji表情
     */
    private String emoji;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
