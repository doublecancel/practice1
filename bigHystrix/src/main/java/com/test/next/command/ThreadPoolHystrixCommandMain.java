package com.test.next.command;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/30.
 */
public class ThreadPoolHystrixCommandMain {

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(a -> {
            ThreadPoolHystrixCommand command = new ThreadPoolHystrixCommand("test1");
            ThreadPoolHystrixCommand2 command2 = new ThreadPoolHystrixCommand2("test2");
            String result = command.execute();
            String result2 = command2.execute();
//            System.out.println(result);

        });

    }

}
