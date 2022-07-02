package com.ghy.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@Slf4j
//@WebListener
public class MySwervletContextListener implements ServletContextListener {

    @Override   //项目的初始化，一启动就会执行
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MySwervletContextListener监听到项目初始化完成");
    }

    @Override   //项目销毁
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MySwervletContextListener监听到项目销毁");
    }
}
