package com.slipper.weblog.modules.user.mapper;

import com.slipper.weblog.core.mybatisplus.expand.BaseMapperX;
import com.slipper.weblog.modules.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface UserMapper extends BaseMapperX<UserEntity> {
}
