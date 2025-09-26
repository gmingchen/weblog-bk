package com.slipper.weblog.core.security.handler;

import com.slipper.weblog.common.enums.ResultCodeEnum;
import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.common.utils.ServletUtils;
import com.slipper.weblog.core.security.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 已认证-无权限处理
 * 由于全局配置了异常 所以全局异常会先捕获 不会执行到这边
 * @author gumingchen
 */
@Slf4j
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ServletUtils.write(response, Result.error(ResultCodeEnum.NOT_ALLOWED));
        log.debug("[访问 URL{} 时，用户({}) 权限不足]", request.getRequestURL(), SecurityUtils.getLoginUserId());
    }
}
