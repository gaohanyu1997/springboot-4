package com.ghy.boot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@MapperScan("com.ghy.boot.mapper") //扫描mapper
@ServletComponentScan(basePackages = "com.ghy.boot")
@SpringBootApplication
public class Springboot4Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot4Application.class, args);
    }

}














