package com.slipper.weblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * 跨域处理配置
 * @author gumingchen
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

//    @Resource
//    private AuthorizationInterceptor authorizationInterceptor;

//    @Resource
//    private UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver;

    /**
     * 页面跨域访问Controller过滤
     * @param corsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
                // 设置允许跨域的路由
                .addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 设置允许的请求头
                .allowedHeaders("*");
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/app/**");
    }
}
