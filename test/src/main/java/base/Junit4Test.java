package base;

import org.junit.*;

/**
 * Created by Administrator on 2017/8/24.
 */
public class Junit4Test {

    @Before
    public void before(){
        System.out.println("before");
    }

    public void test(){
        Assert.assertEquals("is equals:", 1, 1);
    }

    public void test1(){
        Assert.assertEquals("is equals1:", 1, 1);
    }

    @After
    public void after(){
        System.out.println("after");
    }


    @BeforeClass
    public static void init(){
        System.out.println("static before");
    }

    @AfterClass
    public static void destory(){
        System.out.println("static destory");
    }

}
