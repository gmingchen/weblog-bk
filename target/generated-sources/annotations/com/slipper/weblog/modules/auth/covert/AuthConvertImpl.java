package com.slipper.weblog.modules.auth.covert;

import com.slipper.weblog.modules.auth.model.dto.LoginUserDTO;
import com.slipper.weblog.modules.auth.model.dto.TokenDTO;
import com.slipper.weblog.modules.auth.model.vo.EmailLoginVO;
import com.slipper.weblog.modules.auth.model.vo.LoginReqVO;
import com.slipper.weblog.modules.auth.model.vo.QqLoginVO;
import com.slipper.weblog.modules.token.entity.TokenEntity;
import com.slipper.weblog.modules.user.entity.UserEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-28T11:14:13+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class AuthConvertImpl implements AuthConvert {

    @Override
    public EmailLoginVO convertEmail(LoginReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        EmailLoginVO emailLoginVO = new EmailLoginVO();

        emailLoginVO.setEmail( bean.getEmail() );
        emailLoginVO.setUuid( bean.getUuid() );
        emailLoginVO.setCaptcha( bean.getCaptcha() );

        return emailLoginVO;
    }

    @Override
    public QqLoginVO convertQq(LoginReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        QqLoginVO qqLoginVO = new QqLoginVO();

        qqLoginVO.setAccessToken( bean.getAccessToken() );

        return qqLoginVO;
    }

    @Override
    public LoginUserDTO convert(UserEntity bean) {
        if ( bean == null ) {
            return null;
        }

        LoginUserDTO loginUserDTO = new LoginUserDTO();

        loginUserDTO.setId( bean.getId() );
        loginUserDTO.setNickname( bean.getNickname() );
        loginUserDTO.setAvatar( bean.getAvatar() );
        loginUserDTO.setSex( bean.getSex() );
        loginUserDTO.setEmail( bean.getEmail() );

        return loginUserDTO;
    }

    @Override
    public TokenDTO convert(TokenEntity bean) {
        if ( bean == null ) {
            return null;
        }

        TokenDTO tokenDTO = new TokenDTO();

        tokenDTO.setUserId( bean.getCreator() );
        tokenDTO.setToken( bean.getToken() );

        return tokenDTO;
    }
}
