package netty.dubbo.demo

import com.alibaba.dubbo.config.ApplicationConfig
import com.alibaba.dubbo.config.ProtocolConfig
import com.alibaba.dubbo.config.RegistryConfig
import com.alibaba.dubbo.config.ServiceConfig
import netty.dubbo.demo.api.IDemoService
import netty.dubbo.demo.api.IDemoService2
import netty.dubbo.demo.api.IDemoService3
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Administrator on 2017/12/7.
 */
class Provider {

    static main(args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfig.class)

        System.in.read()

    }


}

@Configuration
class ProviderConfig {

    @Bean
    IDemoService iDemoService() {
        IDemoService xxxService = new DemoServiceImpl()

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig()
        application.setName("xxx")

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig()
        registry.setAddress("zookeeper://172.16.5.32:2181")
//        registry.setUsername("aaa")
//        registry.setPassword("bbb")

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig()
        protocol.setServer("netty4")
        protocol.setName("dubbo")
        protocol.setPort(12345)
        protocol.setThreads(200)

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<IDemoService> service = new ServiceConfig<IDemoService>() // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application)
        service.setRegistry(registry) // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol) // 多个协议可以用setProtocols()
        service.setInterface(IDemoService.class)
        service.setRef(xxxService)
        service.setVersion("1.0.0")

        // 暴露及注册服务
        service.export()
        return xxxService
    }

    @Bean
    IDemoService2 iDemoService2() {
        IDemoService2 xxxService = new DemoServiceImpl2()

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig()
        application.setName("xxx")

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig()
        registry.setAddress("zookeeper://172.16.5.32:2181")
//        registry.setUsername("aaa")
//        registry.setPassword("bbb")

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig()
        protocol.setServer("netty4")
        protocol.setName("dubbo")
        protocol.setPort(12345)
        protocol.setThreads(200)

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<IDemoService> service = new ServiceConfig<IDemoService>() // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application)
        service.setRegistry(registry) // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol) // 多个协议可以用setProtocols()
        service.setInterface(IDemoService2.class)
        service.setRef(xxxService)
        service.setVersion("1.0.0")

// 暴露及注册服务
        service.export()
        return xxxService
    }

    @Bean
    IDemoService3 iDemoService3() {
        IDemoService3 xxxService = new DemoServiceImpl3()

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig()
        application.setName("xxx")

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig()
        registry.setAddress("zookeeper://172.16.5.32:2181")
//        registry.setUsername("aaa")
//        registry.setPassword("bbb")

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig()
        protocol.setServer("netty4")
        protocol.setName("dubbo")
        protocol.setPort(12345)
        protocol.setThreads(200)

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<IDemoService> service = new ServiceConfig<IDemoService>() // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application)
        service.setRegistry(registry) // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol) // 多个协议可以用setProtocols()
        service.setInterface(IDemoService3.class)
        service.setRef(xxxService)
        service.setVersion("1.0.0")

// 暴露及注册服务
        service.export()
        return xxxService
    }

}

class DemoServiceImpl implements IDemoService {
    @Override
    String sayHello() {
        return "hello world"
    }
}

class DemoServiceImpl2 implements IDemoService2 {
    @Override
    String sayHello() {
        return "hello world2"
    }
}
class DemoServiceImpl3 implements IDemoService3 {
    @Override
    String sayHello() {
        return "hello world3"
    }
}

