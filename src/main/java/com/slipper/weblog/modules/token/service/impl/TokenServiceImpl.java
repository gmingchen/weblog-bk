package com.slipper.weblog.modules.token.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.core.jwt.utils.JwtUtils;
import com.slipper.weblog.modules.token.entity.TokenEntity;
import com.slipper.weblog.modules.token.mapper.TokenMapper;
import com.slipper.weblog.modules.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author gumingchen
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenMapper, TokenEntity> implements TokenService {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public TokenEntity create(Long userId) {
        String tokenStr = jwtUtils.generate(userId);

        TokenEntity tokenEntity = new TokenEntity()
                .setToken(tokenStr)
                .setExpireAt(jwtUtils.getExpire(tokenStr));
        tokenEntity.setCreator(userId);

        LambdaQueryWrapper<TokenEntity> wrapper = new LambdaQueryWrapper<TokenEntity>()
                .eq(TokenEntity::getCreator, userId);
        TokenEntity token = baseMapper.selectOne(wrapper);
        if (token != null) {
            tokenEntity.setId(token.getId());
        }

        this.saveOrUpdate(tokenEntity);

        return tokenEntity;
    }

    @Override
    public TokenEntity queryByToken(String token) {
        LambdaQueryWrapper<TokenEntity> wrapper = new LambdaQueryWrapper<TokenEntity>()
                .eq(TokenEntity::getToken, token);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public Long queryUserIdByToken(String token) {
        TokenEntity tokenEntity = this.queryByToken(token);
        return tokenEntity.getCreator();
    }

    @Override
    public Boolean validate(String token) {
        TokenEntity tokenEntity = this.queryByToken(token);
        return Optional.ofNullable(tokenEntity)
                .map(w -> w.getExpireAt().isAfter(LocalDateTime.now()) && jwtUtils.validate(token))
                .orElse(false);
    }
}
