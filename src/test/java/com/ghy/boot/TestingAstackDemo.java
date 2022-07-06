package com.ghy.boot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("嵌套测试")
public class TestingAstackDemo {
    Stack<Object> stack;

    @Test
    @DisplayName("new Stack()")
    void isInstantiatedWithNew(){
        new Stack<>();
        //嵌套测试情况下，外层的Test不能驱动内层的Before(After)Each/All之类的方法提前/之后运行
        assertNull(stack);
    }

    @Nested
    @DisplayName("when new")
    class WhenNew{
        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }
        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class,stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing{
            String anElement = "an element";
            @BeforeEach
            void  pushAnElement(){
                stack.push(anElement);
            }
            //内层的Test可以驱动外层的Before(After)Each/All之类的方法提前/之后运行
            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }
            @Test
            @DisplayName("return the element when popped and is empty")
            void returnElementWhenPopped(){
                assertEquals(anElement,stack.pop());
                assertTrue(stack.isEmpty());
            }
            @Test
            @DisplayName("return the element when popped but remains not empty")
            void returnElementWhenPeeked(){
                assertEquals(anElement,stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
