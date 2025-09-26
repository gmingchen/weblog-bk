package com.slipper.weblog.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;

/**
 * @author gumingchen
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 通过用户邮箱查询用户
     * @param email
     * @return
     */
    UserEntity queryUserByEmail(String email);

    /**
     * 通过用户qqOpenId查询用户
     * @param qqOpenId
     * @return
     */
    UserEntity queryUserByQqOpenId(String qqOpenId);

    /**
     * 新增用户
     * @param dto
     * @return
     */
    UserEntity create(UserCreateDTO dto);

}
