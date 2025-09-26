package com.slipper.weblog.common.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author gumingchen
 */
@Data
public class PageParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Long CURRENT = 1L;
    private static final Long SIZE = 10L;
    /**
     * 当前页
     */
    @NotNull(message = "页码不能为空")
    private Long current = CURRENT;
    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不能为空")
    private Long size = SIZE;
}