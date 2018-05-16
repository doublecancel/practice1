package scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scan.dao.CityDao;
import scan.entity.City;
import scan.entity.User;
import scan.what.A;

import java.io.IOException;

/**
 * Created by Administrator on 2017/9/28.
 */
public class App {

    public static void main(String[] args) throws IOException {


        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("scan");

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:application.xml");

        CityDao dao = context.getBean(CityDao.class);
        User user = context.getBean(User.class);

        System.out.println("finally:" + user.toString());

        City city = dao.findCityById(1L);
        System.out.println(city.toString());


        A a = context.getBean(A.class);
        System.out.println(a.test());

        System.in.read();


    }
}
