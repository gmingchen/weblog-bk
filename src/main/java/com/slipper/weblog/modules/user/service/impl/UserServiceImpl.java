package com.slipper.weblog.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.LambdaQueryWrapperX;
import com.slipper.weblog.core.mybatisplus.expand.ServiceImplX;
import com.slipper.weblog.modules.user.covert.UserConvert;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.mapper.UserMapper;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.model.dto.UserPageDTO;
import com.slipper.weblog.modules.user.model.vo.UserPageReqVO;
import com.slipper.weblog.modules.user.model.vo.UserUpdateStatusReqVO;
import com.slipper.weblog.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Service("userService")
public class UserServiceImpl extends ServiceImplX<UserMapper, UserEntity> implements UserService {

    @Override
    public PageResult<UserPageDTO> page(UserPageReqVO reqVO) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapperX<UserEntity>()
                .likeIfPresent(UserEntity::getNickname, reqVO.getNickname())
                .likeIfPresent(UserEntity::getEmail, reqVO.getEmail())
                .eqIfPresent(UserEntity::getStatus, reqVO.getStatus())
                .betweenIfPresent(UserEntity::getCreatedAt, reqVO.getStart(), reqVO.getEnd())
                .orderByDesc(UserEntity::getCreatedAt);
        return UserConvert.INSTANCE.convert(baseMapper.selectPage(reqVO, wrapper));
    }

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

    @Override
    public void updateLoginTime(Long id, LocalDateTime time) {
        LambdaUpdateWrapper<UserEntity> wrapper = new LambdaUpdateWrapper<UserEntity>()
                .eq(UserEntity::getId, id)
                .set(UserEntity::getLastAt, time);
        baseMapper.update(wrapper);
    }

    @Override
    public void updateStatus(UserUpdateStatusReqVO reqVO) {
        UserEntity userEntity = UserConvert.INSTANCE.convert(reqVO);
        baseMapper.updateById(userEntity);
    }
}
