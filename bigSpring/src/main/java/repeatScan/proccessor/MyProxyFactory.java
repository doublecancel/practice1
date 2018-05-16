package repeatScan.proccessor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import repeatScan.annotation.Version;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */
public class MyProxyFactory {


    public static Object createProxy(Class<?> clazz, Map<String, Object> map){

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new MethodInterceptorWe(clazz, map));
        factory.setInterfaces(clazz);
        return factory.getProxy();
    }

    static class MethodInterceptorWe implements MethodInterceptor {


        private Class clazz;
        private Map<String, Object> map;

        public MethodInterceptorWe(Class<?> clazz, Map<String, Object> map) {
            this.clazz = clazz;
            this.map = map;
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {

            int version = getVersionFromConfig();
            Object target = null;
            for (Map.Entry<String, Object> entry : map.entrySet()){

                Object obj = entry.getValue();
                if(obj.getClass().isAnnotationPresent(Version.class)){

                    Version v = obj.getClass().getAnnotation(Version.class);
                    if(v.value() == version){
                        target = obj;
                        break;
                    }
                }
            }

            return invocation.getMethod().invoke(target, invocation.getArguments());
        }
        private Integer getVersionFromConfig(){
            return 2;
        }
    }



}
