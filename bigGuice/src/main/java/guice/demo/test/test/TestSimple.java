package guice.demo.test.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.demo.test.limitservice.IService1;
import guice.demo.test.limitservice.IService2;
import guice.demo.test.modules.AopModuler;
import guice.demo.test.modules.BigModule;
import guice.demo.test.service.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/12/4.
 */
public class TestSimple {

    private ILogService logService;
    private IUserService userService;

    private INameService iNameService;

    @Inject
    @Named("url")
    private String url;

    @Inject
    IProviderService providerService;

    @Inject
    Logger logger;

    @Inject
    IService1 iService1;

    @Inject
    IService2 iService2;

    @Inject
    public TestSimple(ILogService logService, IUserService userService, @Named("nameService1") INameService iNameService) {
        this.logService = logService;
        this.userService = userService;
        this.iNameService = iNameService;
    }

    public static void main(String[] args) {

        Injector injector =  Guice.createInjector(new BigModule(), new AopModuler());
        TestSimple simple = injector.getInstance(TestSimple.class);

//        System.out.println(simple.logService.getClass().getName());
//        System.out.println(simple.userService.getClass().getName());
//        System.out.println(simple.iNameService.getClass().getName());
//        System.out.println(simple.providerService.getClass().getName());
//
//        System.out.println(simple.url);
//
//        simple.logger.info("aaaaaaaaaaaaa");
//
//
//
//        injector.getInstance(IAopService.class).test("abc");

        IntStream.range(1, 11).forEach(a -> {
            try {
                System.out.println(simple.iService1.sayHello());
            } catch (Exception e){
                //ingore
                System.err.println(e.getMessage());
            }
        });
        IntStream.range(1, 11).forEach(a -> {
            try {
                System.out.println(simple.iService2.sayHello());
            } catch (Exception e){
                //ingore
            }
        });


    }



}
