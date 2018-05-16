package coreTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/10/23.
 */
public final class Clock {

    private Long period;
    private LongAdder now = new LongAdder();


    public static Long now(){
        return create().now.longValue();
    }

    public void startScheduler(){
        ScheduledExecutorService service =
                Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "clock");
                t.setDaemon(true);//jvm会退出
                return t;
            }
        });
        service.scheduleWithFixedDelay(() -> {
            now.reset();
            now.add(System.currentTimeMillis());
        }, period, period, TimeUnit.MILLISECONDS);
    }


    public static Clock create(){
        Clock clock = Holder.INSTANCE.getClock() ;
        clock.period = 1L;
        clock.startScheduler();
        return Holder.INSTANCE.getClock();
    }

    enum Holder {
        INSTANCE;
        Clock clock;
        Holder() {
            clock = new Clock();
        }

        private Clock getClock(){
            return clock;
        }
    }


    public static void main(String[] args) {
        IntStream.range(1, 100).forEach(a -> {
            System.out.println(now());
        });
    }

}
