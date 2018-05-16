package protice.factory;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 2017/11/17.
 */
public class BigEventFactory implements EventFactory {


    public static BigEventFactory create(){
        return new BigEventFactory();
    }


    @Override
    public Object newInstance() {
        return null;
    }
}
