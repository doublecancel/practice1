package base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloTest1 {



    @Before
    public void before(){
        System.out.println("HelloTest1 before");
    }

    @Test
    public void test(){
        System.out.println("HelloTest1 test");
    }

    @After
    public void after(){
        System.out.println("HelloTest1 after");
    }


}
