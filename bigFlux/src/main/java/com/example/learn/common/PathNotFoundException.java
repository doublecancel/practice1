package com.example.learn.common;

/**
 * Created by Administrator on 2018/1/31.
 */
public class PathNotFoundException extends SuperException{
    public static PathNotFoundException create (){
        return new PathNotFoundException();
    }
    public static PathNotFoundException create (String message){
        return new PathNotFoundException(message);
    }
    public PathNotFoundException() {
    }

    public PathNotFoundException(String message) {
        super(message);
    }

    public PathNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PathNotFoundException(Throwable cause) {
        super(cause);
    }

    public PathNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
