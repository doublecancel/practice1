package coreTest;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/10/23.
 */
public class TestSystemCurrentTime {


    public static void main(String[] args) {

        test1(100000000);
        test2(100000000);

    }

    private  static void test1(int y){
        Long start = System.currentTimeMillis();
        IntStream.range(1, y).forEach(a -> {
            Long poi = System.currentTimeMillis();
        });
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void test2  (int y){
        Long start = SystemClock.now();
        IntStream.range(1, y).forEach(a -> {
            Long t = SystemClock.now();
        });

        System.out.println(SystemClock.now() - start);
    }

}
