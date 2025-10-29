package com.slipper.weblog.modules.auth.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.auth.model.dto.LoginUserVO;
import com.slipper.weblog.modules.auth.model.dto.TokenVO;
import com.slipper.weblog.modules.auth.model.vo.CaptchaDTO;
import com.slipper.weblog.modules.auth.model.vo.LoginDTO;
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
    public Result<?> captcha(@RequestBody @Validated CaptchaDTO dto) {
        authService.sendCaptcha(dto);
        return Result.success();
    }

    @PostMapping("/pass/login")
    public Result<TokenVO> login(@RequestBody @Validated LoginDTO dto) {
        return Result.success(
                authService.login(dto)
        );
    }

    @GetMapping("/user")
    public Result<LoginUserVO> getUserInfo() {
        return Result.success(
                authService.getLoginUser()
        );
    }
}
