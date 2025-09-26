package com.slipper.weblog.modules.token.entity;

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
@TableName("token")
public class TokenEntity extends BaseEntity {
    /**
     * 凭证
     */
    private String token;
    /**
     * 过期时间
     */
    private LocalDateTime expireAt;
}
