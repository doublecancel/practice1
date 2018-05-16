package annotations;

import entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext
                 = new AnnotationConfigApplicationContext("com");

        User user = configApplicationContext.getBean(User.class);

        String[] names = configApplicationContext.getBeanNamesForType(User.class);

        System.out.println(Arrays.toString(names));

    }
}
