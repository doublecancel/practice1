package com.example.learn.common;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2018/1/31.
 */
public class DatanotFoundException extends SuperException {
    public static DatanotFoundException create (){
        return new DatanotFoundException();
    }
    public static DatanotFoundException create (String message){
        return new DatanotFoundException(message);
    }
    public DatanotFoundException() {
    }

    public DatanotFoundException(String message) {
        super(message);
    }

    public DatanotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatanotFoundException(Throwable cause) {
        super(cause);
    }

    public DatanotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public static Supplier<DatanotFoundException> of(String data){
        return () -> new DatanotFoundException(data);
    }
}
