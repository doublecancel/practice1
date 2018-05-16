package com.example.learn.test;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.*;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/2/2.
 */
public class TestMono {

    @Test
    public void test1(){
        Mono.just(123)
                .subscribe(System.out :: println);
    }

    @Test
    public void test2(){
        Mono.fromCallable(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "success";
        })
                .subscribe(System.out :: println);

        System.out.println("--------------------");

    }

    @Test
    public void test3(){
        Mono.create(a -> {
            showThreadName("create");
            a.success("success");
        })
                .map(a -> {
                    showThreadName("map");
                    return a + "-map";
                })
                .flatMap(a -> {
                    showThreadName("flatmap");
                    return Mono.just(a + "-flatmap");
                })
                .transform(a -> {
                    showThreadName("transform");
                    return Mono.just(a + "-transform");
                })
                .filter(a -> {
                    showThreadName("filter");
                    return true;
                })
                .map(a -> {
                    showThreadName("map2");
                    return a + "-map2";
                })
                .subscribe(a -> {
                   showThreadName("subscribe");
                    System.out.println("subscrive : " + a);
                });
    }


    @Test
    public void test4(){
        Mono.create(a -> {
            showThreadName("create");
            a.success("ok");
        })
//                .publishOn(Schedulers.elastic())
//                .subscribeOn(Schedulers.elastic())
                .map(a -> {
                    showThreadName("map");
                    return a + "-map";
                })
                .publishOn(Schedulers.elastic())
//                .subscribeOn(Schedulers.elastic())
                .filter(a -> {
                    showThreadName("filter");
                    return true;
                })
                .publishOn(Schedulers.elastic())
                .subscribeOn(Schedulers.fromExecutor(executorService()))
                .map(a -> {
                    showThreadName("map2");
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("map2 end ----------");
                    return a + "-map2";
                })
                .doOnSubscribe(a -> {
                    showThreadName("doOnscribe");
                    System.out.println("doOnSubscribe : " + a);
                })
                .subscribe(a -> {
                    showThreadName("subscribe");
                    System.out.println("subscribe : " + a);
                });
    }

    @Test
    public void test5(){
        Mono.create(sink -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            sink.success("ok");
        }).map(a -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a + "-map";
        })
                .timeout(Duration.ofSeconds(3))
                .subscribe(a -> {
                    showThreadName("subscribe");
                    System.out.println(a);
                });
    }


    @Test
    public void test6(){
//        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
//        Flux.fromIterable(list)
//                .subscribe(System.out :: println);


        Flux.create(sink -> {
            sink.next(1);
            sink.next(2);
            sink.next(3);
            sink.next(4);
            sink.complete();
            sink.next(5);
        })
                .map(a -> {
                    showThreadName("map");
                    return a + "-map";
                })
//                .subscribeOn(Schedulers.elastic())
                .publishOn(Schedulers.elastic())
                .map(a -> {
                    showThreadName("map2");
                    return a + "-map2";
                })

                .subscribe(System.out :: println);


    }

    @Test
    public void test7(){
//        Flux.interval(Duration.ofSeconds(1))
//                .subscribe(System.out::println);
//        Flux.generate(sink -> {
//            sink.next("success");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            sink.next("success2");
//            sink.complete();
//        }).subscribe(System.out :: println);

        System.out.println("------------------------------");
        Flux.generate(ArrayList::new, (list, sink) -> {


            int a = ThreadLocalRandom.current().nextInt(100);
            list.add(a);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sink.next(a);
            if(list.size() == 10){
                sink.complete();
            }
            return list;
        }).subscribe(System.out :: println);

//        Flux.create(sink -> {
//            sink.complete();
//        })

    }


    private void showThreadName (String name){
        System.out.println(name + " -  线程名称：" + Thread.currentThread().getName());
    }



    public void mock(MonoSink<String> sink){
        System.out.println("mock ---------------------  " + Thread.currentThread().getName());
        sink.success("success");
        sink.success("success2");
    }

    public ExecutorService executorService(){
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void test8(){
        SampleSubscriber sampleSubscriber = new SampleSubscriber();
        Flux.range(1, 10).subscribe(sampleSubscriber);
    }

    class SampleSubscriber<T> extends BaseSubscriber<T> {

        Subscription subscription;

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            this.subscription = subscription;
            System.out.println("hookOnSubscribe before request");
            subscription.request(2L);
            System.out.println("hookOnSubscribe after request");
//            super.hookOnSubscribe(subscription);
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println("hookOnNext before : " + value);
            subscription.request(1L);
            System.out.println("hookOnNext after : " + value);
            super.hookOnNext(value);
        }

        @Override
        protected void hookOnComplete() {
            super.hookOnComplete();
        }

        @Override
        protected void hookOnError(Throwable throwable) {
            super.hookOnError(throwable);
        }

        @Override
        protected void hookOnCancel() {
            System.out.println("hookOnCancel");
            super.hookOnCancel();
        }

        @Override
        protected void hookFinally(SignalType type) {

            System.out.println("hookOnFinal");
            super.hookFinally(type);
        }
    }

}
