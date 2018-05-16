package scan.proccssor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by Administrator on 2017/9/28.
 */
public class MyFactoryBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition user = beanFactory.getBeanDefinition("user");
        MutablePropertyValues values = user.getPropertyValues();

        if(values.contains("id")){
            values.add("id", "aaa");
        }


        System.out.println("postProcessBeanFactory=========================================");
    }
}
