package retrofit;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/8/22.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface BaseUrl {
    String value () ;
}
