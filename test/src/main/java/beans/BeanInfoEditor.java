package beans;

import java.beans.PropertyEditorSupport;

public class BeanInfoEditor extends PropertyEditorSupport {

    public BeanInfoEditor() {
    }

    public BeanInfoEditor(Object source) {
        super(source);
    }

    @Override
    public String getAsText() {
        return "default";
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setAsText(text);
    }
}
