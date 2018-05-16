package protice.factory;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2017/11/17.
 */
public class BigThreadFactory implements ThreadFactory {

    public static BigThreadFactory create(){
        return new BigThreadFactory();
    }


    @Override
    public Thread newThread(Runnable r) {





        return null;
    }
}
