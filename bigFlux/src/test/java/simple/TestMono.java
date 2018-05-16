package simple;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/2/2.
 */
public class TestMono {

    @Test
    public void test1(){
        Mono.just(123)
                .subscribe(System.out :: println);
        Assert.assertTrue(true);
    }
}
