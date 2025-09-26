package com.slipper.weblog.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 用户
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserEntity extends BaseEntity {
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
     * 角色：0-作者 1-读者
     */
    private Integer role;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
    /**
     * 最后在线时间
     */
    private LocalDateTime lastAt;
}
