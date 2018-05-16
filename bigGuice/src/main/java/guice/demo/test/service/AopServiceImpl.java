package guice.demo.test.service;

import guice.demo.test.annotations.AopInterceptor;

/**
 * Created by Administrator on 2017/12/8.
 */
public class AopServiceImpl implements IAopService {


    @Override
    @AopInterceptor
    public String test(String name) {
        return "hello world";
    }


}
