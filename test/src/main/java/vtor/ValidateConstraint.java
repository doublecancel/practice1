package vtor;

import java.lang.annotation.Annotation;

public interface ValidateConstraint<T extends Annotation> {

    void init(T anotation);



    boolean valid(ValidateContraingContextX context, Object target);




}
