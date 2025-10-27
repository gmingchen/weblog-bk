package com.slipper.weblog.modules.article.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class ArticleUpdateReqVO extends ArticleCreateReqVO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
