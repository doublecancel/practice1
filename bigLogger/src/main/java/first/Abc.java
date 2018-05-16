package first;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/14.
 */
public class Abc {

    public static final int a = 10;
    public static final String bbbbbbbbb = "";
    
    public static void main(String[] args) {

        List<String> l = new ArrayList<>(100);
        l.add("1");


        l.stream().forEach(System.out::println);

        Map<String, String> map = new HashMap<>();

        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });


        l.stream().forEach(System.out::println);


    }


}
