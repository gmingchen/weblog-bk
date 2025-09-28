package com.slipper.weblog.modules.auth.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.auth.model.dto.LoginUserDTO;
import com.slipper.weblog.modules.auth.model.dto.TokenDTO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaReqVO;
import com.slipper.weblog.modules.auth.model.vo.LoginReqVO;
import com.slipper.weblog.modules.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/pass/captcha")
    public Result<?> captcha(@RequestBody @Validated CaptchaReqVO reqVO) {
        authService.sendCaptcha(reqVO);
        return Result.success();
    }

    @PostMapping("/pass/login")
    public Result<TokenDTO> login(@RequestBody @Validated LoginReqVO reqVO) {
        return Result.success(
                authService.login(reqVO)
        );
    }

    @GetMapping("/user")
    public Result<LoginUserDTO> getUserInfo() {
        return Result.success(
                authService.getLoginUser()
        );
    }
}
