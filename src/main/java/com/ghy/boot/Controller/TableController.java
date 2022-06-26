package com.ghy.boot.Controller;

import com.ghy.boot.bean.User;
import com.ghy.boot.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    //不带请求参数或者参数类型不对 400：Bad Request 一般都是浏览器的参数没有传递正确
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表格内容的便利
        List<User> users=Arrays.asList(new User("zhangsan","123456"),
                new User("lisi","99999"),
                new User("wangwu","aaaaa"),
                new User("liuliu","66666"));
        model.addAttribute("users",users);

        if(users.size() > 3 ){
            throw new UserTooManyException();
        }
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
