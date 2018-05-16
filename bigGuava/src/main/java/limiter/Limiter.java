package limiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/12/8.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Limiter {

    double value() default Double.MAX_VALUE;//限流上限

    LimiterType type() default LimiterType.REJECTED;//默认拒绝

}
