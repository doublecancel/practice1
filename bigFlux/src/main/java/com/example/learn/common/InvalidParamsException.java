package com.example.learn.common;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2018/1/31.
 */
public class InvalidParamsException extends SuperException {


    public static InvalidParamsException create (String message){
        return new InvalidParamsException(message);
    }
    public InvalidParamsException() {
    }

    public InvalidParamsException(String message) {
        super(message);
    }

    public InvalidParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParamsException(Throwable cause) {
        super(cause);
    }

    public InvalidParamsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static Supplier<InvalidParamsException> of(String message){
        return new Supplier<InvalidParamsException>() {
            @Override
            public InvalidParamsException get() {
                return new InvalidParamsException(message);
            }
        };
    }
}
