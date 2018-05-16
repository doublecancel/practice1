package base;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloTest.class, HelloTest1.class
})
public class SuiteTest {

    @BeforeClass
    public static void before(){
        System.out.println("SuiteTest before");
    }

//    @Test
//    public void test(){
//        System.out.println("SuiteTest test");
//    }

    @AfterClass
    public static void after(){
        System.out.println("SuiteTest after");
    }



}
