package base;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/30.
 */
public class Rxjava2Test {

    public static void main(String[] args) {


        create().test1();

    }

    public static Rxjava2Test create(){
        return new Rxjava2Test();
    }


    private void test1(){

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                System.out.println("create:" + Thread.currentThread().getName());
                e.onNext(1);

            }
        }).subscribeOn(Schedulers.newThread())
                .map(a -> {
                    System.out.println("map1:" + Thread.currentThread().getName());
                    return a;
                })
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.newThread())
                .map(a -> {
                    System.out.println("map2:" + Thread.currentThread().getName());
                    return a;
                })
                .subscribe(a -> {
                    System.out.println("subscribe:" + Thread.currentThread().getName());
                });



    }


}
