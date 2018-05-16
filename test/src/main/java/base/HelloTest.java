package base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloTest {



    @Before
    public void before(){
        System.out.println("HelloTest before");
    }

    @Test
    public void test(){
        System.out.println("HelloTest test");
    }

    @After
    public void after(){
        System.out.println("HelloTest after");
    }


}
