package com.slipper.weblog.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slipper.weblog.modules.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gumingchen
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
