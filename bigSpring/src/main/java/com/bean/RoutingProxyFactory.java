package com.bean;

import com.annotation.RoutingInjected;
import com.annotation.RoutingSwitch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/9/25.
 */
public class RoutingProxyFactory {

    private static final String type = "A";

    public static Object create(Class clazz, Map<String, Object> map, Field f) {

        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(IUserService.class);
        factory.addAdvice(new RoutingMethodInterceptor(map, clazz, f));
        return factory.getProxy();
    }


    public static class RoutingMethodInterceptor implements MethodInterceptor {
        Field f;
        Map<String, Object> map;
        Class<?> interf;

        private static Map<String, Object> cache = new ConcurrentHashMap<>();

        public RoutingMethodInterceptor(Map<String, Object> map, Class<?> interf, Field f) {
            this.map = map;
            this.interf = interf;
            this.f = f;
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {


            RoutingInjected injected = f.getAnnotation(RoutingInjected.class);
            String target = injected.value();
            init(map.values());
            Object obj = cache.get(getKeyName(interf, target));

            return invocation.getMethod().invoke(obj, invocation.getArguments());

        }


        private void init(Collection<Object> values){
            for(Object obj : values){
                RoutingSwitch routingSwitch = obj.getClass().getAnnotation(RoutingSwitch.class);
                String key = getKeyName(interf, routingSwitch.value());
                cache.put(key, obj);
            }
        }

        private String getKeyName(Class<?> interf, String target){
            return interf.getName() + ":" + target;
        }


    }

}
