package guava;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/1/8.
 */
public class Test {

    public static void main(String[] args) {

        Double a = 1.0;

        for (int i = 0; i < 10000; i++) {
            boolean equals = new BigDecimal(a).compareTo(new BigDecimal(a + "")) == 0;
//            System.out.println("a : " + a + ", result : " + equals);
            a++;
        }

        Float b = new Float(1.01);

        for (int i = 0; i < 10000; i++) {
            boolean equals = new BigDecimal(b).compareTo(new BigDecimal(b + "")) == 0;
            System.out.println("a : " + a + ", result : " + equals);
            a++;
        }


    }


}
