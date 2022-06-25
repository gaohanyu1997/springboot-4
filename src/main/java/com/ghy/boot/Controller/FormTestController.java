package com.ghy.boot.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 文件上传测试
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    //MultipartFile 自动封装上传过来的文件
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String userName,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={},userName={},headerImg={},photos={}",
                email,userName,headerImg.getSize(),photos.length);
        //单文件上传
        if(!headerImg.isEmpty()){
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("H:\\" + originalFilename));
        }
        //多文件上传
        if(photos.length > 0){
            for(MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String photoFileName = photo.getOriginalFilename();
                    photo.transferTo(new File("H:\\" + photoFileName));

                }
            }
        }
        return "main";
    }
}
