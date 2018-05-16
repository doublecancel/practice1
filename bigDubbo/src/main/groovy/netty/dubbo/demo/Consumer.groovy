package netty.dubbo.demo

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ReferenceConfig
import com.alibaba.dubbo.config.RegistryConfig
import netty.dubbo.demo.api.IDemoService
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
/**
 * Created by Administrator on 2017/12/7.
 */
class Consumer {

    static main(args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class)


        IDemoService demoService = context.getBean(IDemoService.class)
        println demoService.sayHello()


        System.in.read()
    }

}


@Configuration
class ConsumerConfig {

    @Bean
    IDemoService iDemoService(){
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig()
        application.setName("yyy")

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig()
        registry.setAddress("zookeeper://172.16.5.32:2181")

        com.alibaba.dubbo.config.ConsumerConfig consumerConfig = new com.alibaba.dubbo.config.ConsumerConfig()
        consumerConfig.setClient("netty4")

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<IDemoService> reference = new ReferenceConfig<IDemoService>() // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏

        reference.setConsumer(consumerConfig)

        reference.setApplication(application)
        reference.setRegistry(registry) // 多个注册中心可以用setRegistries()
        reference.setInterface(IDemoService.class)
        reference.setVersion("1.0.0")

        // 和本地bean一样使用xxxService
        return reference.get() // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
    }



}
