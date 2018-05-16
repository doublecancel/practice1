package test;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/11/16.
 */
public class Main {

    public static void main(String[] args) {

        MyEventFactory factory = new MyEventFactory();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        int ringBufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(
                factory,
                ringBufferSize,
                (r) -> {
                  return new Thread(r);
                },
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );
        EventHandler<LongEvent> handler = (e1, s, e) -> {
            System.out.println("handler:" + e1.getValue());
        };
        disruptor.handleEventsWith(handler);
        disruptor.start();//启动

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();

        LongEvent event = ringBuffer.get(sequence);
        event.setValue(Long.MAX_VALUE);

        ringBuffer.publish(sequence);

    }



}
