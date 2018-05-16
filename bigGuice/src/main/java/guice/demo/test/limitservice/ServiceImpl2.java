package guice.demo.test.limitservice;

import guice.demo.test.annotations.Limiter;

/**
 * Created by Administrator on 2017/12/8.
 */
public class ServiceImpl2 implements  IService2{
    @Override
    @Limiter(200)
    public String sayHello() {
        return "say hello world 2";
    }
}
