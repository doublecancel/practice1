package inner;

import inner.service.CityService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/9/19.
 */

public class App {

    public static void main(String[] args) throws Exception{

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("inner");

        context.start();

        CityService service = context.getBean(CityService.class);
        System.out.println(service == null);

        System.in.read();

    }


}
