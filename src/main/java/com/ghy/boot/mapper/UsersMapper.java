package com.ghy.boot.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ghy.boot.bean.Users;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
