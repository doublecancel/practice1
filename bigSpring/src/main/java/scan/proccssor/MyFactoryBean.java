package scan.proccssor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2017/9/28.
 */
public class MyFactoryBean<T> implements FactoryBean<T> {



    public Class<T> interf;

    public MyFactoryBean() {
    }

    public MyFactoryBean(Class<T> interf) {
        this.interf = interf;
    }

    public Class<T> getInterf() {
        return interf;
    }

    public void setInterf(Class<T> interf) {
        this.interf = interf;
    }

    @Override
    public T getObject() throws Exception {

        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(interf);
        factory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {

                if(invocation.getMethod().getName().equals("test")){
                    return "OK";
                }

                return "NO";
            }
        });
        return (T)factory.getProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return this.interf;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
