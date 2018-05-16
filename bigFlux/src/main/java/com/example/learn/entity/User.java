package com.example.learn.entity;

import lombok.Data;

/**
 * Created by Administrator on 2018/1/31.
 */
@Data
public class User {
    private Long id ;
    private String username ;
    private String password ;
    private String email ;
    private String mobile ;
    private String readName ;
}
