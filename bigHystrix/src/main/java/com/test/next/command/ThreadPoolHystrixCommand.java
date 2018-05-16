package com.test.next.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

/**
 * Created by Administrator on 2017/9/30.
 */
public class ThreadPoolHystrixCommand extends HystrixCommand<String> {

    private static Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("singleton"));

    private String name;

    protected ThreadPoolHystrixCommand(String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String run() {
        showThreadMessage();
        return "oooo";
    }

    private void showThreadMessage() {
        System.out.println(name + ", thread:" + Thread.currentThread().getName());
    }
}
