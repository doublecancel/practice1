package javaN;

import java.util.Observable;

/**
 * Created by Administrator on 2017/8/23.
 */
public class MyObservable extends Observable {



    public MyObservable(){
        super.addObserver(new MyObserver());
    }

    public void invoke(){

        super.setChanged();

        super.notifyObservers(123);


    }


}
