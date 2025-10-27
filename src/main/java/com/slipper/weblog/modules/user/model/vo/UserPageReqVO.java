package com.slipper.weblog.modules.user.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageDateParam;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class UserPageReqVO extends PageDateParam {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态：0-禁用 1-启用
     */
    @Enum(StatusEnum.class)
    private Integer status;
}
