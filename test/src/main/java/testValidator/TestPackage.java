package testValidator;

import com.google.common.base.Predicates;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Test
public class TestPackage {

    @Test
    private void test(){}

    @Test
    public static void main(String[] args) {
        Class clazz = TestPackage.class;
        System.out.println(clazz.isAnnotationPresent(Test.class));
        System.out.println(clazz.getPackage().getName());
        String packageName = clazz.getPackage().getName();

        Package pak = Package.getPackage(packageName);
        Annotation[] as = pak.getAnnotations();
        Arrays.stream(as).filter(Predicates.notNull()).forEach(a -> {
            System.out.println("value : " + ((Test)a).value());
        });
        System.out.println(pak.isAnnotationPresent(Test.class));
    }


}
