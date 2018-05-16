package guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEventBus {

    private EventBus bus = null;
    private static final String msg = "OK";

    @Subscribe
    public void subscribe(String message){
        System.out.println(message);
        Assert.assertEquals(message, msg);
    }

    @Before
    public void before(){
        bus = new EventBus("default-test");
        bus.register(this);
    }

    @Test
    public void test(){
        bus.post(msg);
    }

    @After
    public void destory(){
        bus.unregister(this);
        bus = null;
    }



}
