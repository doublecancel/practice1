package com.test.command;

import rx.Observer;

/**
 * Created by Administrator on 2017/9/29.
 */
public class HelloObservableCommand {


    public static void main(String[] args) {

        HelloObaservableCommand command = new HelloObaservableCommand("test");

//        command.observe().subscribe(a -> {
//            System.out.println("subscribe : " + a);
//        });

        command.observe()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext:" + s);
                    }
                });

//        command.observe()
//
//                .subscribe(a -> {
//
//                });


    }

}
