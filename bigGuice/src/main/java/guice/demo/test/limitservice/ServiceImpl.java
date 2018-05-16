package guice.demo.test.limitservice;

import guice.demo.test.annotations.Limiter;

/**
 * Created by Administrator on 2017/12/8.
 */
public class ServiceImpl implements IService1{


    @Override
    @Limiter(2)
    public String sayHello() {
        return "say hello world 1";
    }



}
