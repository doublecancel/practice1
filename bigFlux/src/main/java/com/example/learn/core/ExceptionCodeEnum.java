package com.example.learn.core;

import com.example.learn.common.DatanotFoundException;
import com.example.learn.common.InvalidParamsException;

/**
 * Created by Administrator on 2018/2/1.
 */
public enum ExceptionCodeEnum {

    DEFAULT_CODE(null, 20000),
    DATA_NOT_FOUND(DatanotFoundException.class, 10001),
    INVALID_PARAMS(InvalidParamsException.class, 10002);

    private Class clazz;
    private int code;

    ExceptionCodeEnum(Class clazz, int code) {
        this.clazz = clazz;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static int getCode(Class clazz1){
        ExceptionCodeEnum[] es =  ExceptionCodeEnum.values();
        for (ExceptionCodeEnum e : es){
            if(e.clazz == clazz1){
                return e.code;
            }
        }
        return ExceptionCodeEnum.DEFAULT_CODE.code;
    }
}
