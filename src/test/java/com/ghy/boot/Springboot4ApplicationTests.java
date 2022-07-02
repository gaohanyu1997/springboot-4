package com.ghy.boot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Springboot4ApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        /*jdbcTemplate.queryForObject("select * from pms_attr");*/
        Long aLong = jdbcTemplate.queryForObject("select count(*) from pms_attr",Long.class);
        log.info("记录总数：{}", aLong);
        log.info("数据源类型：{}", dataSource.getClass());

    }

}





