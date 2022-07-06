package com.ghy.boot;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("测试断言")
public class Junit5Test2 {
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(3, 3);
        //相等
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    int cal(int i, int j){
        return i + j;
    }

    @Test
    @DisplayName("array assertion")
    public void array(){
        assertArrayEquals(new int[]{1,2},new int[]{1,3},"数组内容不相等");
    }

   //所有断言全部需要成功
    @Test
    @DisplayName("组合断言")
    void all(){
        assertAll("test",
                () -> assertTrue(true && true,"结果不为true"),
                () -> assertEquals(1,1,"结果不是1"));
        System.out.println("=======");  //断言全部成功时才会继续往下面执行
    }

    @Test
    @DisplayName("异常断言")
    void testExecption(){
        //断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class,
                () -> {int i = 10/0;},
                "业务逻辑居然正常运行？");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){
        //xxxx
        if(2 == 2){
            fail("测试失败");
        }
    }

    // 测试前置条件
    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("111111");
    }

}
