package com.ghy.boot.service;
import com.ghy.boot.bean.Account;
import com.ghy.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    public Account getById(Integer id){
        return accountMapper.getAccount(id);
    }
}
