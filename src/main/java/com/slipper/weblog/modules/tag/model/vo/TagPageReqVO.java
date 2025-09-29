package com.slipper.weblog.modules.tag.model.vo;

import com.slipper.weblog.common.pojo.PageParam;
import lombok.Data;

@Data
public class TagPageReqVO extends PageParam {
    /**
     * 名称
     */
    private String name;
}
