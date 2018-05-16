package com.example.learn.core;

/**
 * Created by Administrator on 2018/2/1.
 */
public class Optionals<T> {

    private T t;

    public static <A> Optionals ofEmptyable(A t){
        Optionals optionals = new Optionals();
        optionals.t = t;
        return optionals;
    }

    public T or(T defaultValue){
        if(t == null || t.equals("")){
            return defaultValue;
        }
        return t;
    }

    public T orThrow(RuntimeException e){
        if(t == null || t.toString().trim().equals("")){
            throw e;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println("".equals("    "));
    }

}
