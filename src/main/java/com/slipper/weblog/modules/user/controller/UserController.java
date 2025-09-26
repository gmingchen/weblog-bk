package com.slipper.weblog.modules.user.controller;

import com.slipper.weblog.modules.user.entity.UserEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "success1";
    }

    @GetMapping("/pass/test")
    public String testPass() {
        return "success2";
    }


    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/test/role")
    public String testRole() {
        return "success3";
    }

    @PostMapping("/pass/test/html")
    public String testHtml(@RequestBody UserEntity user) {
        return user.getNickname();
    }
}
