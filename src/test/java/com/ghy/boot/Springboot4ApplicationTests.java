package com.ghy.boot;

import com.ghy.boot.bean.Users;
import com.ghy.boot.mapper.UsersMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Springboot4ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void testJedis(){
        System.out.println(redisConnectionFactory.getClass());
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
    }

    @Test
    void contextLoads() {
        /*jdbcTemplate.queryForObject("select * from pms_attr");*/
        Long aLong = jdbcTemplate.queryForObject("select count(*) from pms_attr",Long.class);
        log.info("记录总数：{}", aLong);
        log.info("数据源类型：{}", dataSource.getClass());

    }

    @Test
    void testUsersMapper(){
        Users users = usersMapper.selectById(1L);
        log.info("用户信息{}",users);
    }

}





