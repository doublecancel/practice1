package enums;

import com.google.common.collect.Lists;

public class TestReduce {
    public static void main(String[] args) {
       int a =  Lists.newArrayList(1, 2, 3, 4)
                .stream()
                .reduce(0, (t, b) -> {
                    System.out.println("t : " + t + ", b : " + b);
                    return t + b;
                });
        System.out.println(a);

        String s = "a";
        String s1 = new String("a");
        System.out.println(s == s1);



        String s2 = "a";
        System.out.println(s == s2);
        String s3 = new String("a");
        System.out.println(s1 == s3);
    }
}
