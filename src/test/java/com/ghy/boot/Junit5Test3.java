package com.ghy.boot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@DisplayName("参数化测试")
public class Junit5Test3 {
    @DisplayName("参数化测试")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterized(int i){
        System.out.println(i);
    }

    @DisplayName("参数化测试")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testParameterized2(String i){
        System.out.println(i);
    }
    static Stream<String> stringProvider(){
        return Stream.of("apple","banana","atguigu");
    }
}
