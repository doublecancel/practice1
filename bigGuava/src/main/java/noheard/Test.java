package noheard;

import com.google.common.net.InternetDomainName;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/12/8.
 */
public class Test {


    public static void main(String[] args) {

//        test1();
//        test2();

        test4();
    }


    public static void test1 (){

        int a = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(Integer.toUnsignedString(a + 1));


        long b = UnsignedInteger.fromIntBits(1 << 32).longValue();
        System.out.println(b);

    }



    public static void test2(){

        final RateLimiter limiter = RateLimiter.create(2);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        final Long start  = System.currentTimeMillis();
        IntStream.range(1, 11).forEach(a -> {
            limiter.acquire();
            System.out.println("a:" + a);
        });

        System.out.println(System.currentTimeMillis() - start);

    }

    public static void test3 (){

        final RateLimiter limiter = RateLimiter.create(5000);

        ExecutorService pool = Executors.newFixedThreadPool(4);
        final Long start  = System.currentTimeMillis();
        IntStream.range(1, 11).forEach(a -> {
            limiter.acquire();
            System.out.println("a:" + a);
        });

        System.out.println(System.currentTimeMillis() - start);



    }


    public static void test4(){
        InternetDomainName domainName = InternetDomainName.from("www.baidu.com");


        domainName.parts().forEach(a -> {
            System.out.println(a.toString());
        });


    }



}
