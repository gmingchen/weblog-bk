package com.slipper.weblog.modules.tag.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class TagUpdateSortDTO {
    /**
     * ID数组
     */
    @NotNull(message = "ID不能为空")
    @Size(min = 1, message = "至少有一个ID")
    private List<Long> ids;
    /**
     * 排序：越大位置越靠前
     */
    @NotNull(message = "排序不能为空")
    private Integer sort;
}
