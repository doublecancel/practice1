package test;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.Data;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Main2 {

    public static void main(String[] args) {

        int ringBufferSize = 1024;

        Disruptor<MyEvent> disruptor
                 = new Disruptor<MyEvent>(
                () -> new MyEvent(),
        ringBufferSize,
                (r) -> {return new Thread(r);},
                ProducerType.SINGLE,
        new YieldingWaitStrategy()
        );

        disruptor.handleEventsWith((event, seq, end) -> {
            System.out.println("event:" + event.getValue() + ", seq:" + seq + ",end:" + end);

        }).then((event, seq, end) -> {
            System.out.println("event:" + event.getValue() + ", seq:" + seq + ",end:" + end);
        });


        disruptor.start();


        RingBuffer<MyEvent> buffer = disruptor.getRingBuffer();



        IntStream.range(1, 100).forEach(a -> {
            new Thread(() -> {
                long sequence = buffer.next();

                MyEvent event = buffer.get(sequence);
                event.setValue(Long.MAX_VALUE);

                buffer.publish(sequence);
            }).start();
        });

    }

    @Data
    static class MyEvent{
        private Long value;
    }



}
