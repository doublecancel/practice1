package test.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import test.service.UserService;

/**
 * Created by Administrator on 2018/1/17.
 */
public class City {

    @Autowired
    UserService service;


    public City(WebApplicationContext context) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
        bpp.setBeanFactory( context.getAutowireCapableBeanFactory());
        bpp.processInjection(this);
        System.out.println("---------------------------");

    }

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(2862933555777941757L));
    }

}
