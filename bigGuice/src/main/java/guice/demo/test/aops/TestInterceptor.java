package guice.demo.test.aops;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2017/12/8.
 */
public class TestInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("before--------------------------------");
        Object result = invocation.proceed();//执行真实的方法
        System.out.println("after--------------------------------");


        return result;
    }
}
