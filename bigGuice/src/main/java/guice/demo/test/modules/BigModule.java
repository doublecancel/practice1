package guice.demo.test.modules;

import com.google.inject.AbstractModule;
import com.google.inject.internal.SingletonScope;
import com.google.inject.name.Names;
import guice.demo.test.service.*;

/**
 * Created by Administrator on 2017/12/4.
 */
public class BigModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(IUserService.class).to(UserServiceImpl.class).in(new SingletonScope());
        bind(ILogService.class).to(LogServiceImpl.class).in(new SingletonScope());
        bind(INameService.class).annotatedWith(Names.named("nameService1")).to(NameServiceImpl.class).in(new SingletonScope());
        bind(String.class).annotatedWith(Names.named("url")).toInstance("mysql://localhost:3306/world");
    }

//    @Provides
    protected IProviderService iProviderService(){
        return new ProviderServiceImpl();
    }



}
