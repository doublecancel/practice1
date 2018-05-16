package demo;

import com.lmax.disruptor.*;
import test.LongEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {



        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;
        EventFactory<LongEvent> eventFactory = () -> new LongEvent();
        RingBuffer<LongEvent> ringBuffer= RingBuffer.createSingleProducer(eventFactory, BUFFER_SIZE);

        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);

        WorkHandler<LongEvent> workHandlers =  (t) -> {  };
        /*
         * 这个类代码很简单的，亲自己看哈！~
         */
        WorkerPool<LongEvent> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), workHandlers);

        workerPool.start(executor);

        //下面这个生产8个数据，图简单就写到主线程算了
        IntStream.range(1, 10).forEach(a -> {
            long seq=ringBuffer.next();
            ringBuffer.get(seq).setValue(111L);
            ringBuffer.publish(seq);
        });

        Thread.sleep(1000);
        workerPool.halt();
        executor.shutdown();
    }


}
