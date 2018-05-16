package guice.demo.test.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/12/8.
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Limiter {

    double value() default Double.MAX_VALUE;

    boolean reject() default true;//默认拒绝报错，如果设置为不拒绝则请求会发生积压

}
