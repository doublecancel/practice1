package vtor.constraints;

import vtor.ValidateConstraint;
import vtor.ValidateContraingContextX;

public class NotNullOrEmptyConstraint implements ValidateConstraint<NotNullOrEmpty> {

    private String value;
    @Override
    public void init(NotNullOrEmpty anotation) {
        value = anotation.message();
    }

    @Override
    public boolean valid(ValidateContraingContextX context, Object target) {
        return false;
    }
}
