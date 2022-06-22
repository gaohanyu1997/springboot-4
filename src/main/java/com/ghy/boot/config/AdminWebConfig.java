package com.ghy.boot.config;

import com.ghy.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* 1 编写一个拦截器 实现 WebMvcConfigurer接口
* 2 拦截器注册到容器中(实现WebMvcConfigurer的addInterceptors())
* 3 指定拦截规则【如果是拦截所有,静态资源也会被拦截】
* */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //所有请求都会被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行的请求
    }
}
