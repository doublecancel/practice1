package protice;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import protice.event.BaseEvent;
import protice.factory.BigEventFactory;
import protice.factory.BigThreadFactory;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Startup {

    private static final int ringBufferSize = 1024;

    public static void main(String[] args) {


        Disruptor<BaseEvent> disruptor =
                new Disruptor<BaseEvent>(
                        BigEventFactory.create(),
                        ringBufferSize,
                        BigThreadFactory.create(),
                        ProducerType.SINGLE,//一个生产者
                        new YieldingWaitStrategy()//等待策略
                );


    }



    static void runInThread(){
        new Thread(() -> {

        }).start();
    }

}
