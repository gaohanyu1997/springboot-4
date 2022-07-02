package com.ghy.boot.mapper;
import com.ghy.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AccountMapper {

    public Account getAccount(Integer id);

}
