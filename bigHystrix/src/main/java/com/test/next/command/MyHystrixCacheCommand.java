package com.test.next.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * Created by Administrator on 2017/9/30.
 */
public class MyHystrixCacheCommand extends HystrixCommand<Integer> {

    private Integer cache;

    private String name;

    private static Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("sinletong"))
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("factory"));

    protected MyHystrixCacheCommand(String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected Integer run() throws Exception {


        cache = 1;

        showThreadMessage();

        return cache;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(cache);
    }


    private void showThreadMessage(){
        System.out.println(name + ", thread:" + Thread.currentThread().getName());
    }


}
