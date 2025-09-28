package com.slipper.weblog.modules.user.covert;

import com.slipper.weblog.modules.user.entity.UserEntity;
import com.slipper.weblog.modules.user.model.dto.UserCreateDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-28T11:14:13+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserEntity convert(UserCreateDTO bean) {
        if ( bean == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setNickname( bean.getNickname() );
        userEntity.setAvatar( bean.getAvatar() );
        userEntity.setSex( bean.getSex() );
        userEntity.setEmail( bean.getEmail() );
        userEntity.setQqOpenId( bean.getQqOpenId() );

        return userEntity;
    }
}
