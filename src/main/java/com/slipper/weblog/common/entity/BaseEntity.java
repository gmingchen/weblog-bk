package com.slipper.weblog.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建者，用户ID
     */
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.BIGINT)
    private Long creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createdAt;
    /**
     * 更新者，用户ID
     */
    @TableField(fill = FieldFill.UPDATE, jdbcType = JdbcType.BIGINT)
    private Long updater;
    /**
     * 最后更新时间
     */
    @TableField(fill = FieldFill.UPDATE, jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updatedAt;
    /**
     * 更新者，用户ID
     */
    private Long deleter;
    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;
    /**
     * 是否删除
     */
    @TableLogic()
    private Boolean deleted;
}
