package com.slipper.weblog.modules.user.controller;

import com.slipper.weblog.common.pojo.PageResult;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.user.model.dto.UserPageDTO;
import com.slipper.weblog.modules.user.model.vo.UserPageReqVO;
import com.slipper.weblog.modules.user.model.vo.UserUpdateStatusReqVO;
import com.slipper.weblog.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/page")
    public Result<PageResult<UserPageDTO>> page(@Validated UserPageReqVO reqVO) {
        return Result.success(
                userService.page(reqVO)
        );
    }

    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @PostMapping("/update/status")
    public Result<?> updateStats(@RequestBody @Validated UserUpdateStatusReqVO reqVO) {
        userService.updateStatus(reqVO);
        return Result.success();
    }

}
