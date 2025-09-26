package com.slipper.weblog.modules.token.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.token.entity.TokenEntity;

/**
 * @author gumingchen
 */
public interface TokenService extends IService<TokenEntity> {
    /**
     * 新增Token
     * @param userId 用户ID
     * @return
     */
    TokenEntity create(Long userId);

    /**
     * 通过Token查询
     * @param token token
     * @return
     */
    TokenEntity queryByToken(String token);

    /**
     * 通过Token查询用户ID
     * @param token Token
     * @return
     */
    Long queryUserIdByToken(String token);

    /**
     * 校验Token
     * @param token Token
     * @return
     */
    Boolean validate(String token);
}
