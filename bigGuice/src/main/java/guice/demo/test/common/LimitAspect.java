package guice.demo.test.common;

import com.google.common.util.concurrent.RateLimiter;
import com.google.inject.Inject;
import guice.demo.test.annotations.Limiter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/8.
 */
public class LimitAspect implements MethodInterceptor{

    @Inject
    Map<String, RateLimiter> map;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        boolean a = invocation.getMethod().isAnnotationPresent(Limiter.class);
        if(a){
            Limiter limiter = invocation.getMethod().getDeclaredAnnotation(Limiter.class);
            String key = generateKey(invocation);
            if(map.containsKey(key)){

                if(limiter.reject()){
                    if(!map.get(key).tryAcquire()){
                        throw new RuntimeException("流量超过限制，拒绝接受请求");
                    }else{
                        return invocation.proceed();
                    }
                }

                map.get(key).acquire();//阻塞
                return invocation.proceed();
            }
        }
        return invocation.proceed();
    }

    String generateKey(MethodInvocation invocation){
        Method m = invocation.getMethod();
        return m.getDeclaringClass().getName()+ "." + m.getName();
    }
}
