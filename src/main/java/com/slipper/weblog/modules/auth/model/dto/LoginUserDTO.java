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
}
