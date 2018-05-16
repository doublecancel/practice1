package demo;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;
import test.LongEvent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {

        final RingBuffer<LongEvent> ringBuffer  = RingBuffer.createSingleProducer(
                () -> new LongEvent(),
                1024,
                new YieldingWaitStrategy()
        );

        ExecutorService executors = Executors.newFixedThreadPool(10);
        SequenceBarrier barrier = ringBuffer.newBarrier();

        BatchEventProcessor<LongEvent> transProcessor = new BatchEventProcessor<LongEvent>(
                ringBuffer, barrier, (event, seq, end) -> {
            System.out.println("event:" + event.getValue() + ", seq:" + seq + ",end:" + end);

        });

        ringBuffer.addGatingSequences(transProcessor.getSequence());

        executors.submit(transProcessor);

        Future<?> future = executors.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                IntStream.range(1, 1000).forEach(a -> {
                    long seq=ringBuffer.next();//占个坑 --ringBuffer一个可用区块

                    ringBuffer.get(seq).setValue(1000L);//给这个区块放入 数据  如果此处不理解，想想RingBuffer的结构图

                    ringBuffer.publish(seq);//发布这个区块的数据使handler(consumer)可见
                });
                return null;
            }
        });

        future.get();//等待生产者结束
        Thread.sleep(1000);//等上1秒，等消费都处理完成
        transProcessor.halt();//通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
        executors.shutdown();



    }



}
