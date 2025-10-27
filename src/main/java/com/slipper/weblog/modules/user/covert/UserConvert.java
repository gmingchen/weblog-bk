package com.slipper.weblog.modules.user.covert;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import com.slipper.weblog.modules.user.model.dto.UserPageDTO;
import com.slipper.weblog.modules.user.model.vo.UserUpdateStatusReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author gumingchen
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    PageResult<UserPageDTO> convert(PageResult<UserEntity> bean);

    UserEntity convert(UserCreateDTO bean);

    UserEntity convert(UserUpdateStatusReqVO bean);
}
