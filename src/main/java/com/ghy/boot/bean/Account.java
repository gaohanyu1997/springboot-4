package com.ghy.boot.bean;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Account {
    private Integer id;
    private String userId;
    private String money;
}
