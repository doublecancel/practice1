package guice.demo.test.modules;

import com.google.common.util.concurrent.RateLimiter;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.SingletonScope;
import com.google.inject.matcher.Matchers;
import guice.demo.test.annotations.AopInterceptor;
import guice.demo.test.annotations.Limiter;
import guice.demo.test.aops.TestInterceptor;
import guice.demo.test.common.LimitAspect;
import guice.demo.test.common.MyProvider;
import guice.demo.test.limitservice.IService1;
import guice.demo.test.limitservice.IService2;
import guice.demo.test.limitservice.ServiceImpl;
import guice.demo.test.limitservice.ServiceImpl2;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/8.
 */
public class AopModuler extends AbstractModule {

    @Inject
    Map<String, RateLimiter> map;

    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(AopInterceptor.class), new TestInterceptor());

        bind(IService1.class).to(ServiceImpl.class).in(new SingletonScope());
        bind(IService2.class).to(ServiceImpl2.class).in(new SingletonScope());

        LimitAspect limitAspect = new LimitAspect();

        requestInjection(limitAspect);// interceptor 中可以注入，需要
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Limiter.class), limitAspect);
        TypeLiteral typeLiteral = new TypeLiteral<Map<String, RateLimiter>>(){};
        bind(typeLiteral)
                .toProvider(MyProvider.create())
                .in(new SingletonScope());

    }




}
