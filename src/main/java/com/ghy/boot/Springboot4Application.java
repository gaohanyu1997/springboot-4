package com.ghy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.ghy.boot")
@SpringBootApplication
public class Springboot4Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot4Application.class, args);
    }

}














