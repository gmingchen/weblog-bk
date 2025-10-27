package com.slipper.weblog.modules.user.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Data
public class UserPageDTO {
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
     * QQopenid
     */
    private String qqOpenId;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
    /**
     * 最后在线时间
     */
    private LocalDateTime lastAt;
    /**
     * 注册时间
     */
    private LocalDateTime createdAt;
}
