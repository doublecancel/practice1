package test;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import test.entity.City;

/**
 * Created by Administrator on 2018/1/15.
 */
@SpringBootApplication
@EnableWebMvc
@DubboComponentScan
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    WebApplicationContext context;

    @Bean
    public Object test(){
//        City c = context.getBean(City.class)     ;
        new City(context);

//        City c1 = context.getBean(City.class)     ;
        ContextLoader.getCurrentWebApplicationContext();


//        WebApplicationContextUtils.findWebApplicationContext()
        return new Object();
    }

}
