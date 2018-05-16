package vtor.constraints;

import vtor.Constrant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constrant(NotNullOrEmptyConstraint.class)
public @interface NotNullOrEmpty {
    String message() default "not null or empty";
}
