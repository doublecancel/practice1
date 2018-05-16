package springTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/8/25.
 */
@Configuration
@ComponentScan("springTest.service")
public class TestConfig {

    @Bean
    public Object config(){
        System.out.println("create bean");
        return new Object();
    }

}
