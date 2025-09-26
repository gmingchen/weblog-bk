package com.slipper.weblog.modules.captcha.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 验证码
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("captcha")
public class CaptchaEntity extends BaseEntity {
    /**
     * UUID
     */
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireAt;
}
