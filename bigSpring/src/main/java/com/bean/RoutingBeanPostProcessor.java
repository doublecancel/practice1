package com.bean;

import com.annotation.RoutingInjected;
import com.google.common.base.Preconditions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/25.
 */
@Component
public class RoutingBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        Field[] fs = clazz.getDeclaredFields();
        for(Field f : fs){
            boolean flag = f.isAnnotationPresent(RoutingInjected.class);
            if(flag){
                Preconditions.checkArgument(f.getType().isInterface(), "must be a interface");
                try {
                    handler(bean, f, f.getType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    private void handler(Object bean , Field f, Class clazz) throws IllegalAccessException {
        Map<String, Object> map = context.getBeansOfType(clazz);
        int size = map.size();
        Preconditions.checkArgument(size > 0, "no bean avaiable");
        if(size == 1){
            f.set(bean, map.values().iterator().next());
        }
        if(size == 2){
            f.set(bean, RoutingProxyFactory.create(clazz, map, f));
        }

    }



    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
