package com.test.command;

import com.google.common.collect.Lists;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29.
 */
public class HelloObaservableCommand extends HystrixObservableCommand<String> {

    private String name;

    protected HelloObaservableCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("Example"));
        this.name = name;
    }

    private List<String> data = Lists.newArrayList("a", "b", "c");


    @Override
    protected Observable<String> construct() {
        return Observable.from(data);
    }
}
