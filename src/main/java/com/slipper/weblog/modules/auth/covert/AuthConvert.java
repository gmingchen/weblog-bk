package com.slipper.weblog.modules.auth.covert;

import com.slipper.weblog.modules.auth.model.dto.LoginUserDTO;
import com.slipper.weblog.modules.auth.model.dto.TokenDTO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginVO;
import com.slipper.weblog.modules.auth.model.vo.LoginReqVO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginVO;
import com.slipper.weblog.modules.token.entity.TokenEntity;
import com.slipper.weblog.modules.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author gumingchen
 */
@Mapper
public interface AuthConvert {
    AuthConvert INSTANCE = Mappers.getMapper(AuthConvert.class);

    EmailLoginVO convertEmail(LoginReqVO bean);

    QqLoginVO convertQq(LoginReqVO bean);

    LoginUserDTO convert(UserEntity bean);

    @Mapping(target = "userId", source = "creator")
    TokenDTO convert(TokenEntity bean);

}
