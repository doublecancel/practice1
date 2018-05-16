package repeatScan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repeatScan.Bean.UserController;

/**
 * Created by Administrator on 2017/11/2.
 */
public class App {

    public static void main(String[] args) throws Exception {


        AnnotationConfigApplicationContext app
                = new AnnotationConfigApplicationContext("repeatScan");

        app.start();

        UserController userController = app.getBean(UserController.class);

        System.in.read();



    }

}
