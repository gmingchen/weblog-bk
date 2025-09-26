package com.slipper.weblog.modules.user.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author gumingchen
 */
@Accessors(chain = true)
@Data
public class UserCreateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
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
     * QQopenid
     */
    private String qqOpenId;
}
