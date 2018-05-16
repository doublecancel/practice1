package com.test.command;

import rx.Observable;
import rx.Observer;

/**
 * Created by Administrator on 2017/9/29.
 */
public class ObservableCommand {


    public static void main(String[] args) {

        HelloworldCommand command = new HelloworldCommand(ObservableCommand.class.getName());



        Observable<String> observable = command.observe();//定义一个事件源
        observable.subscribe(a -> {//创建一个监听并且订阅该事件源
            System.out.println("subscribe:" + a);
        });

        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted ");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError :" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext :" + s);
            }
        });



//        command.execute();

    }

}
