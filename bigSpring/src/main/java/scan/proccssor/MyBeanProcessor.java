package scan.proccssor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import scan.entity.User;

/**
 * Created by Administrator on 2017/9/28.
 */
public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        if(bean instanceof User){
            System.out.println("postProcessBeforeInitialization:" + bean.toString());
            User u = (User)bean;
            u.setId("123456");
        }




        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof User){
            System.out.println("postProcessAfterInitialization:" + bean.toString());
            User u = (User)bean;
            u.setId("11111");
        }


        return bean;
    }
}
