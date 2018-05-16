package repeatScan.proccessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import repeatScan.annotation.RejectedX;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */
@Component
public class MyBeanProcessor implements BeanPostProcessor , ApplicationContextAware{

    private ApplicationContext applicationContext;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after init");
        Field[] fs = bean.getClass().getDeclaredFields();
        for (Field field : fs){
            if(field.isAnnotationPresent(RejectedX.class)){
                if(!field.getType().isInterface()){
                    return bean;
                }
                handler(bean, field.getType(), field);
            }
        }
        return bean;
    }

    private void handler(Object bean, Class aClass, Field field) {
        field.setAccessible(true);
        Map<String, Object> map = applicationContext.getBeansOfType(aClass);
        try {
            if (map.size() == 1){
                field.set(bean, applicationContext.getBean(aClass));
            } else if (map.size() > 1){
                field.set(bean, MyProxyFactory.createProxy(aClass, map));
            } else{
                return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
