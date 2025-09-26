package com.slipper.weblog.core.security.filter;

import com.slipper.weblog.core.security.utils.SecurityUtils;
import com.slipper.weblog.modules.auth.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Token 过滤器 验证token
 * 验证通过 将用户信息存入 Security 上下文
 * @author gumingchen
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = SecurityUtils.getToken(request);
        Boolean flag = authService.validateToken(token);
        if (StringUtils.isNotBlank(token) && Boolean.TRUE.equals(flag)) {
            Optional.ofNullable(authService.queryUserByToken(token))
                    .ifPresent(loginUser -> {
                        String role = loginUser.getRole() == 0 ? "ROLE_AUTHOR" : "ROLE_READER";
                        Set<SimpleGrantedAuthority> roles  = new HashSet<>();
                        roles.add(new SimpleGrantedAuthority(role));
                        SecurityUtils.setLoginUser(loginUser, roles, request);
                    });
        }
        filterChain.doFilter(request, response);
    }
}
