package com.ghy.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghy.boot.bean.Users;
import com.ghy.boot.mapper.UsersMapper;
import com.ghy.boot.service.UsersService;
import org.springframework.stereotype.Service;
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
