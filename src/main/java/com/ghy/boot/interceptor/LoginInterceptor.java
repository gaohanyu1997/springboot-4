package com.ghy.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// 登录检查
// 1 配置好拦截器要拦截哪些请求
// 2 把这些配置放在容器中
// 3
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override       //目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}"+requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            //放行
            return true;
        }
        //拦截住，未登录，跳转到登录页
        request.setAttribute("msg","请先登录！");
        *//*response.sendRedirect("/");*//*
        request.getRequestDispatcher("/").forward(request,response);
        return false;*/
        return true;
    }

    @Override       //目标方法执行之后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    @Override       //页面渲染以后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常",ex);
    }
}
