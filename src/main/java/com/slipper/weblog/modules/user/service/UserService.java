package com.slipper.weblog.modules.user.service;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.core.mybatisplus.expand.IServiceX;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.model.dto.UserPageDTO;
import com.slipper.weblog.modules.user.model.vo.UserPageReqVO;
import com.slipper.weblog.modules.user.model.vo.UserUpdateStatusReqVO;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
public interface UserService extends IServiceX<UserEntity> {

    /**
     * 分页列表
     * @param reqVO 参数
     * @return
     */
    PageResult<UserPageDTO> page(UserPageReqVO reqVO);

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

    /**
     * 更新登录时间
     * @param id ID
     * @param time 登录时间
     */
    void updateLoginTime(Long id, LocalDateTime time);

    /**
     * 更新状态
     * @param reqVO 参数
     */
    void updateStatus(UserUpdateStatusReqVO reqVO);
}
