package vtor;

public class ItemCheck {
    private String message;
    private ValidateConstraint validateConstraint;
    private String name;

    public ItemCheck(ValidateConstraint validateConstraint, String name) {
        this.validateConstraint = validateConstraint;
        this.name = name;
    }

    public ValidateConstraint getValidateConstraint() {
        return validateConstraint;
    }

    public void setValidateConstraint(ValidateConstraint validateConstraint) {
        this.validateConstraint = validateConstraint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
