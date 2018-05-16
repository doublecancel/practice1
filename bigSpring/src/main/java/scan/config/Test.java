package scan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scan.proccssor.MyBeanProcessor;
import scan.proccssor.MyFactoryBeanPostProcessor;
import scan.proccssor.MyScanner;

/**
 * Created by Administrator on 2017/9/28.
 */
@Configuration
public class Test {
    @Bean
    public MyBeanProcessor myBeanProcessor(){
        return new MyBeanProcessor();
    }

    @Bean
    public MyFactoryBeanPostProcessor myFactoryBeanPostProcessor(){
        return new MyFactoryBeanPostProcessor();
    }

    @Bean
    public MyScanner myScanner(){
        return new MyScanner();
    }


}
