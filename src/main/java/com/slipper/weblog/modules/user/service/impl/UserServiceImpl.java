package com.slipper.weblog.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slipper.weblog.modules.user.covert.UserConvert;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.mapper.UserMapper;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author gumingchen
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public UserEntity queryUserByEmail(String email) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getEmail, email);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public UserEntity queryUserByQqOpenId(String qqOpenId) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getQqOpenId, qqOpenId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public UserEntity create(UserCreateDTO dto) {
        UserEntity userEntity = UserConvert.INSTANCE.convert(dto);

        baseMapper.insert(userEntity);

        return userEntity;
    }
}
