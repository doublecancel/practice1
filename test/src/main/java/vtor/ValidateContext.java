package vtor;

import com.google.common.collect.Lists;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateContext {

    Map<String, List<ItemCheck>> map = new HashMap<>();



    private ValidateContext(){}

    public static ValidateContext create(){
        return new ValidateContext();
    }

    private void add(ItemCheck check){
        String name = check.getName();
        List<ItemCheck> checks = map.get(name);
        if(checks == null || checks.size() < 1){
            checks = new ArrayList<>();
        }
        checks.add(check);
    }

    private void addAll(List<ItemCheck> list){
        for(ItemCheck check : list){
            add(check);
        }
    }

    public void resolveClass(Class clazz){
        try {
            collectAnnotationsFromTarget(clazz);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    public void collectAnnotationsFromTarget(Class clazz) throws IntrospectionException{
        List<ItemCheck> list = Lists.newArrayList();
        Field[] fs = clazz.getDeclaredFields();
        for(Field f : fs){
            List<ItemCheck> list2 = collectAnnotationsFromField(f, clazz);
            addAll(list2);
        }
    }

    private List<ItemCheck> collectAnnotationsFromField(Field f, Class clazz) throws IntrospectionException{
        List<ItemCheck> list = Lists.newArrayList();
        PropertyDescriptor descriptor = new PropertyDescriptor(f.getName(), clazz);
        Annotation[] as = f.getAnnotations();
        for(Annotation a : as){
            Constrant constrant = a.annotationType().getAnnotation(Constrant.class);
            ValidateConstraint constraint = newInstance(constrant);
            constraint.init(constrant);

            ItemCheck check = new ItemCheck(constraint, f.getName());
            list.add(check);
        }
        return list;
    }

    private ValidateConstraint newInstance(Constrant constrant){
        ValidateConstraint constraint = null;
        Class clazz = constrant.value();
        try {
            constraint = (ValidateConstraint)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return constraint;
    }



}
