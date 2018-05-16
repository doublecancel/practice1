package vtor;


public class ValidateContraingContextX {

    private VtorX vtorx;

    private String targetName;

    private Object target;


    public ValidateContraingContextX(VtorX vtorx, String targetName, Object target) {
        this.vtorx = vtorx;
        this.targetName = targetName;
        this.target = target;
    }

    public VtorX getVtorx() {
        return vtorx;
    }

    public void setVtorx(VtorX vtorx) {
        this.vtorx = vtorx;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
