package com.slipper.weblog.core.security.utils;

import com.slipper.weblog.common.constant.TokenConstant;
import com.slipper.weblog.common.utils.HttpContextUtils;
import com.slipper.weblog.modules.user.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 安全服务工具
 * @author gumingchen
 */
public class SecurityUtils {
    /**
     * 获取 TOKEN
     * 先从 请求头中查找 如果不存在 从参数中查找
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(TokenConstant.TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TokenConstant.TOKEN_KEY);
        }
        return token;
    }

    /**
     * 获取 TOKEN
     * 先从 请求头中查找 如果不存在 从参数中查找
     * @return
     */
    public static String getToken() {
        return getToken(HttpContextUtils.getHttpServletRequest());
    }

    /**
     * 获取当前的认证信息
     * @return
     */
    public static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        return context.getAuthentication();
    }

    /**
     * 获取当前登录管理员
     * @return
     */
    public static UserEntity getLoginUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getPrincipal() instanceof UserEntity ? (UserEntity) authentication.getPrincipal() : null;
    }

    /**
     * 获取当前登录管理员ID
     * @return
     */
    public static Long getLoginUserId() {
        UserEntity userEntity = getLoginUser();
        return userEntity != null ? userEntity.getId() : null;
    }

    /**
     * 设置当前用户到上下文中
     * @param loginUser 用户
     * @param roles 角色集合
     * @param request
     */
    public static void setLoginUser(UserEntity loginUser, Set<? extends GrantedAuthority> roles, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginUser, null, roles);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
