package cn.spring.security.demo.common;

import lombok.Data;

/**
 * Created by Administrator on 2017/11/6.
 */
@Data
public class Response {
    private Integer code;
    private Boolean success;
    private String message;
}
