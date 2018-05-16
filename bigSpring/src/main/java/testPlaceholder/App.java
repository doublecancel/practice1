package testPlaceholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;

/**
 * Created by Administrator on 2018/1/8.
 */
@Configuration
public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                 = new AnnotationConfigApplicationContext("testPlaceholder");

        String name = context.getEnvironment().getPropertySources().get("application.yml").getName();
        System.out.println(name);
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        InputStreamResource resource = new InputStreamResource(App.class.getResourceAsStream("/abc.properties"));

        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(resource);
        configurer.setLocalOverride(true);
        return configurer;
    }

}
