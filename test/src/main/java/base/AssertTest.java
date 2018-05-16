package base;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/23.
 */
public class AssertTest {

    @Test
    public void testAssertEquals(){
        Assert.assertEquals("should equals:", "text", "text1");
    }

    @Test
    public void testAssertNull(){
//        Assert.assertNull("should null:" , new Object());
        Assert.assertNotNull("should null:" , null);
    }

    @Test
    public void testArray(){

    }

    @Test
    public void testAssertThatBothContainsString(){

        Assert.assertThat("bbbb",
                CoreMatchers.both(CoreMatchers.containsString("a"))
                .and(CoreMatchers.containsString("a")));//是否包含指定的字符串

    }

    @Test
    public void testAssertThathasItem(){
        Assert.assertThat(Arrays.asList(1, 2, 3), CoreMatchers.hasItem(20));
    }

    @Test
    public void testAssertThatEveryItemContainsString(){

        Assert.assertThat(Arrays.asList("ab", "be", "cb"), CoreMatchers.everyItem(CoreMatchers.containsString("b")));

    }

    @Test
    public void testAssertThatHamcrestCoreMatchers(){


        Assert.assertThat("good", CoreMatchers.allOf(CoreMatchers.equalTo("good"), CoreMatchers.startsWith("good")));


        Assert.assertThat("good", CoreMatchers.not(CoreMatchers.equalTo("gppd")));


    }

}
