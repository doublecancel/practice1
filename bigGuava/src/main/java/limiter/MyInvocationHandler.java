package limiter;

import com.google.common.util.concurrent.RateLimiter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/8.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;
    Map<String, RateLimiter> map;

    public MyInvocationHandler(Object obj, Map<String, RateLimiter> map) {
        this.obj = obj;
        this.map = map;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Limiter limiter = method.getAnnotation(Limiter.class);


        return null;
    }
}
