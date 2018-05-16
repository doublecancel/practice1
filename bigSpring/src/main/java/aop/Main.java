package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2017/9/25.
 */
public class Main {

    public static void main(String[] args) {

        UserServiceImpl user = new UserServiceImpl();


        ( (IUserService)get(user)).sayHello();

    }

    private static Object get(IUserService target){
        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(IUserService.class);
        factory.addAdvice(new MyMethodInterceptor(target));
        return factory.getProxy();
    }


    static class MyMethodInterceptor implements MethodInterceptor{

        private Object target;

        public MyMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {

            System.out.println("pre");

            return invocation.getMethod().invoke(target, invocation.getArguments());
        }
    }


}
