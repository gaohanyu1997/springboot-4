package com.ghy.boot.bean;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
//@TableName("user_tal")
public class Users {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
