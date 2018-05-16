package eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/23.
 */
public class Simple {

    public static String getThreadName(){
        return Thread.currentThread().getName();
    }

    @Subscribe
    public void observer(String a){
        System.out.println("observer:" + getThreadName());
//        System.out.println("observer:" + a);
    }

    @Subscribe
    public void observer1(String a){
        System.out.println("observer1:" + getThreadName());
//        System.out.println("observer1:" + a);
    }

    @Subscribe
    public void no(DeadEvent deadEvent){
        Object event = deadEvent.getEvent();
        Object source = deadEvent.getSource();

        System.out.println(event + ":" + source);

    }

    public static void main(String[] args) {

        Simple simple = new Simple();
        EventBus bus = new EventBus();
        bus.register(simple);

        bus.post("abc1");

        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));

        asyncEventBus.register(simple);
        asyncEventBus.post("async_01");
        asyncEventBus.post("async_02");
        asyncEventBus.post("async_03");

    }

}
