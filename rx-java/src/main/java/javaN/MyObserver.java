package javaN;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/8/23.
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update...:" + arg);
    }
}
