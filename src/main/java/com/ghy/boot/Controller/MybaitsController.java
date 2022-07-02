package com.ghy.boot.Controller;
import com.ghy.boot.bean.Account;
import com.ghy.boot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MybaitsController {
    @Autowired
    AccountService accountService;
    @ResponseBody
    @GetMapping("/account")
    public Account getById(@RequestParam("id") Integer id){
        return accountService.getById(id);
    }
}
