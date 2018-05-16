package com.example.learn.common;

/**
 * Created by Administrator on 2018/1/31.
 */
public class SuperException extends RuntimeException {

    public int code;


    public SuperException setCode(int code){
        this.code = code;
        return this;
    }




    public static SuperException create (String message){
        return new SuperException(message);
    }
    public SuperException() {
    }

    public SuperException(String message) {
        super(message);
    }

    public SuperException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperException(Throwable cause) {
        super(cause);
    }

    public SuperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
