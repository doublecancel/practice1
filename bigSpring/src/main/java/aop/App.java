package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/9/25.
 */
public class App {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("aop");

        context.start();


        System.in.read();
    }

}
