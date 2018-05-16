package test;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 2017/11/16.
 */
public class MyEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
