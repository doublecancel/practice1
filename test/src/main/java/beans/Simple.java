package beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class Simple {

    public static void main(String[] args) throws Exception{

        BeanInfo beanInfo =  Introspector.getBeanInfo(City.class);

        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
//        log(beanDescriptor.getBeanClass().getName());
//        log(beanDescriptor.getCustomizerClass());
//        log(beanDescriptor.getDisplayName());
//        log(beanDescriptor.getShortDescription());

        beanInfo.getDefaultEventIndex();
        beanInfo.getDefaultPropertyIndex();
        beanInfo.getEventSetDescriptors();

        beanInfo.getMethodDescriptors();


        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Arrays.stream(propertyDescriptors).forEach(a -> {
//            log("--------------------------------------------" + a.getName());
//            log(Optional.ofNullable(a.getReadMethod()).map(b -> b.getName()).orElse("null"));
//            log(Optional.ofNullable(a.getWriteMethod()).map(b -> b.getName()).orElse("null"));
//            log(Optional.ofNullable(a.getPropertyType()).map(b -> b.getName()).orElse("null"));
//            log(Optional.ofNullable(a.getPropertyEditorClass()).map(b -> b.getName()).orElse("null"));
            if(a.getName().equals("name")){
                a.setPropertyEditorClass(BeanInfoEditor.class);
            }
        });

        City city = new City();
        log(city.getName());

        BeanInfoEditor editor = new BeanInfoEditor(city);
//        editor.setAsText("abc");
        log(editor.getAsText());
        log(city.getName());
    }
    private static void log(Object message){
        if(message == null){
            System.out.println("null");
            return;
        }
        System.out.println(message.toString());
    }

    public static class City {
        private Long id;
        private String name;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
