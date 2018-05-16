package guice.demo.test.common;

import com.google.common.util.concurrent.RateLimiter;
import com.google.inject.*;
import guice.demo.test.annotations.Limiter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/12/8.
 */
public class MyProvider implements Provider<Map<String, RateLimiter>> {


    @Inject
    Injector injector;


    public static MyProvider create(){
        return new MyProvider();
    }

    @Override
    public Map<String, RateLimiter> get() {
        System.out.println("get--------------------------------");
        Map<String, RateLimiter> rateLimiterMap = new HashMap<>();
        Map<Key<?>, Binding<?>> map = injector.getAllBindings();
        map.forEach((k, v) -> {

            Class clazz = v.getKey().getTypeLiteral().getRawType();
            Method[] ms = clazz.getDeclaredMethods();
            List<Method> mlist  = Arrays.stream(ms).filter(a -> a.isAnnotationPresent(Limiter.class)).collect(Collectors.toList());

            mlist.forEach(a -> {
                rateLimiterMap.put(generateKey(clazz, a), RateLimiter.create(a.getAnnotation(Limiter.class).value()));
            });
        });
        return rateLimiterMap;
    }



    String generateKey(Class c, Method m){
        return c.getName() + "." + m.getName();
    }

}
