package cn.spring.security.demo.common;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Administrator on 2017/11/6.
 */
public class InncorrectPasswordException extends AuthenticationException {

    public static InncorrectPasswordException create(){
        return new InncorrectPasswordException("");
    }
    public static InncorrectPasswordException create(String message){
        return new InncorrectPasswordException(message);
    }


    public InncorrectPasswordException(String msg, Throwable t) {
        super(msg, t);
    }

    public InncorrectPasswordException(String msg) {
        super(msg);
    }
}
