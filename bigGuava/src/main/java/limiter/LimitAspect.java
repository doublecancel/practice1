package limiter;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.Reflection;
import com.google.common.util.concurrent.RateLimiter;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created by Administrator on 2017/12/8.
 * FIXME 代码移植到bigGuice
 */
public class LimitAspect {

    private Map<String, RateLimiter> limitmap = new HashMap<>();
    private Map<String, Function> operates = new HashMap<>();

    private Map<Class<?>, Object> needProxy = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        LimitAspect aspect = new LimitAspect();
        aspect.init();

        System.out.println(new Gson().toJson(aspect.limitmap));
        System.out.println(new Gson().toJson(aspect.needProxy));

    }

    public synchronized void init(){


        try {
            Set<ClassPath.ClassInfo> set = ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClasses("service");
            set.forEach( a -> {
                Class clazz = a.load();
                Method[] ms = clazz.getDeclaredMethods();

                boolean isNeedproxy= Arrays.stream(ms).filter(b -> b.isAnnotationPresent(Limiter.class)).findAny().isPresent();
                if(isNeedproxy){
                    if(!clazz.isInterface()){
                        try {
                            needProxy.put(clazz.getSuperclass(), clazz.newInstance());
                        } catch (InstantiationException  | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Arrays.stream(ms).filter(b -> b.isAnnotationPresent(Limiter.class))
                        .forEach(b -> {
                            limitmap.put(generateKey(clazz, b), newLimiter(b));
                        });

            });


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private RateLimiter newLimiter(Method m){

        Limiter limiter  = m.getAnnotation(Limiter.class);
        return RateLimiter.create(limiter.value());


    }

    private String generateKey(Class clazz, Method m){
        String key = clazz.getName() + "." +  m.getName();//生成key
        return key;
    }



    Object createProxyBatch(){
        needProxy.forEach((k, v) -> {
            Reflection.newProxy(k, new MyInvocationHandler(v, limitmap));
        });
        return null;
    }







}
