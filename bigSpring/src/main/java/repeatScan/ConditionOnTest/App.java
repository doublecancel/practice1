package repeatScan.ConditionOnTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/11/2.
 */
public class App {

    public static void main(String[] args) throws Exception {


        AnnotationConfigApplicationContext app
                = new AnnotationConfigApplicationContext("repeatScan.ConditionOnTest");

        app.start();

        ICityService service = app.getBean(ICityService.class);
        System.out.println(service.getCityName());

        System.in.read();



    }

}
