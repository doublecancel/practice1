package repeatScan.proccessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import repeatScan.Bean.IUserService;

/**
 * Created by Administrator on 2017/11/2.
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext ac;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory post");
        IUserService userService = ac.getBean(IUserService.class);
        System.out.println(userService.getUserName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }
}
