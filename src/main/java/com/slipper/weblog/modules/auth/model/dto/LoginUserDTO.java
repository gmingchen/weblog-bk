package com.slipper.weblog.modules.auth.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gumingchen
 */
@Data
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别 0-女 1-男 2-未知
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色：0-作者 1-读者
     */
    private Integer role;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
