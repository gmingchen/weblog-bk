package com.slipper.weblog.modules.auth.covert;

import com.slipper.weblog.modules.auth.model.dto.LoginUserVO;
import com.slipper.weblog.modules.auth.model.dto.TokenVO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginDTO;
import com.slipper.weblog.modules.auth.model.vo.LoginDTO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginDTO;
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

    EmailLoginDTO convertEmail(LoginDTO bean);

    QqLoginDTO convertQq(LoginDTO bean);

    LoginUserVO convert(UserEntity bean);

    @Mapping(target = "userId", source = "creator")
    TokenVO convert(TokenEntity bean);

}
