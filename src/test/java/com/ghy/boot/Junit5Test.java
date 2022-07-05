package com.ghy.boot;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.concurrent.TimeUnit;
/*
* @BootstrapWith(SpringBootTestContextBootstrapper.class)
* @ExtendWith({SpringExtension.class})
* */
//@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @DisplayName("测试displayname1注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }
    @DisplayName("测试方法2")
    @Disabled
    @Test
    void test2(){
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3(){
        System.out.println(4);
    }

    //规定方法超时时间。超出时间测试出异常
    @Test
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了。。。");
    }
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了。。。");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了。。。");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了。。。");
    }
}
