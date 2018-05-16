package com.test.recover;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by Administrator on 2017/9/30.
 */
public class RecoverCommand extends HystrixCommand<String> {

    private static Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("RecoverCommand"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
            .withCircuitBreakerRequestVolumeThreshold(10)//线程最大容量，默认20
            .withCircuitBreakerErrorThresholdPercentage(60)//错误率，默认50
//                    .withFallbackIsolationSemaphoreMaxConcurrentRequests(10)
            .withCircuitBreakerSleepWindowInMilliseconds(5000));//休眠时间，默认5s

    //default_fallbackIsolationSemaphoreMaxConcurrentRequests


    private Integer num;

    protected RecoverCommand(Integer name) {

        super(setter);
        this.num = name;

    }

    @Override
    protected String run() throws Exception {
        System.out.println("run:" + num);
//        if (num <= 10){//100%
//            Integer.parseInt("abc");
//        }
        if (num <= 5){//50%
            Integer.parseInt("abc");
        }
//        if (num <= 1){//10%
//            Integer.parseInt("abc");
//        }
        return "OK";
    }


    @Override
    protected String getFallback() {
        System.out.println("getFallback:");
        return "ERROR";
    }
}
