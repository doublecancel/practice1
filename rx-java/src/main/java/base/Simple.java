package base;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/8/21.
 */
public class Simple {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();

//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();

//        test11();


//        testDebounce();

//        test12();

//        test13();

        test14();

    }

    public static void test1(){
        //创建一个被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe(){
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("a");
                e.onNext("b");
                e.onNext("c");
                e.onNext("d");
            }
        });

        //创建一个观察者
        Observer observer = new Observer() {
            private Disposable d;
            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext:" + o);

                //取消订阅
                if(o.equals("c")){
                    d.dispose();
                }

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };


        observable.subscribe(observer);
    }


    public static void test2(){


        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                System.out.println("create subscribe:" + Thread.currentThread().getName());
                e.onNext("a");
            }
        })
                .subscribeOn(newSchedulers("a"))
                .observeOn(newSchedulers("b"))
                .doOnNext(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println("doOnNext:" + Thread.currentThread().getName());
                    }
                })

                .observeOn(newSchedulers("c"))
                .doOnNext(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println("doOnNext:" + Thread.currentThread().getName());
                    }
                })
                .map(a -> {
                    return a + "7";
                })
                .observeOn(newSchedulers("d"))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println("subscribe:" + Thread.currentThread().getName());
                    }
                });







    }


    public static void test3(){


        Observable observable1 = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                e.onNext("a");
                System.out.println("observable1");
                e.onComplete();
            }
        });

        Observable observable2 = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                e.onNext("b");
                System.out.println("observable2");
            }
        });
        Observable.concat(observable1, observable2)
                .subscribeOn(newSchedulers("observable"))
                .observeOn(newSchedulers("observe"))
                .doOnNext((a) -> {
                    System.out.println("doOnNext:" + getThreadName());
                })
                .subscribe((a) -> {
                    System.out.println("subscribe:" + getThreadName());
                });






    }


    public static void test4(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
            }
        })
                .subscribeOn(newSchedulers("observable"))
//                .observeOn(newSchedulers("observe"))
                .doOnNext(a -> {
                    System.out.println("主线程消费：" + a + ":" + getThreadName());
                })
//                .flatMap(a -> {
//                    if(a == 1){
//                        return new Observable<Integer>() {
//                            @Override
//                            protected void subscribeActual(Observer<? super Integer> observer) {
//                                observer.onNext(2);
//                            }
//                        };
//                    }
//                    return null;
//                })
                .observeOn(newSchedulers("observe"))
                .subscribe((a) -> {
                    System.out.println("subscribe" + getThreadName());
                    System.out.println("a : " + a);

                });

    }

    public static void test5(){


        Flowable.interval(2, TimeUnit.SECONDS)
//                .create(new FlowableOnSubscribe<Object>() {
//                    @Override
//                    public void subscribe(FlowableEmitter<Object> e) throws Exception {
//                        System.out.println("subscribe...");
//                        e.onNext(1);
////                        e.onComplete();
//                    }
//                }, BackpressureStrategy.BUFFER)
                .subscribe((a) -> {
                    System.out.println("a");
                });


    }



    public static void test6(){

        Observable.just("a", "b", "c")//依次发送
                .subscribe((a) -> {
                    System.out.println(a);
                });
    }

    public static void test7(){
        Consumer onNext = (t) -> {
            System.out.println("onNext" + t);
        };

        Consumer onException = (t) -> {
            System.out.println("onNext1" + t);
        };

        Action onComplete = () -> {
            System.out.println("action:");
        };

        Observable.just("a")
                .subscribe(onNext, onException, onComplete);

    }


    public static void test8(){
        String[] strs = new String[]{"a", "b", "c", "d"};
        Observable.fromArray(strs)//将集合中的每一个元素作为一个事件发送
                .subscribe((a) -> {
                    System.out.println(a);
                });
    }

    public static void test9(){
        Course course1 = new Course(1L, "语文1");
        Course course2 = new Course(2L, "数学2");
        Course course3 = new Course(3L, "英语3");
        Course course4 = new Course(4L, "历史4");
        Course course5 = new Course(5L, "化学5");
        Course course6 = new Course(6L, "物理6");

        Student student1 = new Student(1L, "lxl01", Lists.newArrayList(course1, course2));
        Student student2 = new Student(2L, "lxl02", Lists.newArrayList(course4, course5));
        Student student3 = new Student(3L, "lxl03", Lists.newArrayList(course3, course6));

        Student[] students = {student1, student2, student3};

        Observable.fromArray(students)
                .subscribe((a) -> {
                    System.out.println(a.getCourses().toString());
                });

        System.out.println("---------------------------------------");

        Observable.fromArray(students)
                .map(a -> a.getCourses())
                .subscribe((a) -> {
                    System.out.println(a);
                });

        System.out.println("---------------------------------------");

        Observable.fromArray(students)
                .flatMap(a -> {
                    return Observable.fromArray(a.getCourses());//铺平
                })
                .subscribe((a) -> {
                    System.out.println(a);
                });
    }


    public static void testDebounce(){
        List<Object> l = new CopyOnWriteArrayList();
            Observable.create(new ObservableOnSubscribe<Object>() {

                @Override
                public void subscribe(ObservableEmitter<Object> e) throws Exception {
                    IntStream.range(1, 10).forEach(a -> {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        e.onNext(a);
                    });
                    e.onComplete();
                }
            })
                    .debounce(1, TimeUnit.SECONDS)
                    .observeOn(newSchedulers("test"))
                    .switchMap((o) -> {
                        if((int)o == 2){
                            TimeUnit.SECONDS.sleep(4);
                        }
                        if((int)o == 8){
                            throw new RuntimeException("error");
                        }

                        System.out.println("o:" + o);
                        return Observable.just(o).subscribeOn(newSchedulers("a"));
                    })
                    .retryWhen(a -> {

                        a.flatMap(t -> {
                            System.out.println("message:" + t.getMessage());
                            return null;
                        });

                        return Observable.just(a).subscribeOn(newSchedulers("a"));

                    })
                    .onErrorResumeNext(a -> {
                        System.out.println("onErrorResumeNext:" + a);
                    })

                    .subscribe((b) -> {
                        System.out.println("consumer:" + b);
                    }, (t) -> {
                        t.printStackTrace();
                    });
    }

    public static void test10(){

        Flowable flowable = Flowable.create(new FlowableOnSubscribe<Object>() {
            @Override
            public void subscribe(FlowableEmitter<Object> e) throws Exception {
                for(int a = 0; a < 130; a++){
//                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("emit:" + a);
                    e.onNext(a);
                    System.out.println("剩余数量：" + e.requested());
                }
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR);


        Subscriber subscriber = new Subscriber() {
            private Subscription s;
            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
//                s.request(5L);
            }
            @Override
            public void onNext(Object o) {
                System.out.println("consumer:" + o);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };

        Flowable.create(new FlowableOnSubscribe<Long>() {
            @Override
            public void subscribe(FlowableEmitter<Long> e) throws Exception {
                for(long a = 0; a < 10000; a++){
//                    System.out.println("emit:" + a);
                    e.onNext(a);
                }
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR)
//                .subscribeOn(newSchedulers("a"))
                .observeOn(newSchedulers("test"))
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });






    }

    public static void test11(){

        Flowable.create(new FlowableOnSubscribe<Object>() {

            @Override
            public void subscribe(FlowableEmitter<Object> e) throws Exception {
                IntStream.range(1, 100).forEach(a -> {
                    e.onNext(a);
                });
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribe((a) -> {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("consumer:" + a);
                }, (e) -> {
                    System.out.println(e.getMessage());
                });




    }


    public static void test12(){

        Single.create(new SingleOnSubscribe<Object>() {
            @Override
            public void subscribe(SingleEmitter<Object> e) throws Exception {
                e.onSuccess(1);
//                e.onError(new RuntimeException("abc"));
            }
        }).subscribe((a) -> {
            System.out.println(a);
        }, (t) -> {
            System.out.println(t.getMessage());
        });

        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter e) throws Exception {
                e.onComplete();
//                e.onError(new RuntimeException("yyy"));
            }
        }).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println("complete...");
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        Maybe.create(new MaybeOnSubscribe<Object>() {
            @Override
            public void subscribe(MaybeEmitter<Object> e) throws Exception {
                e.onComplete();
                e.onSuccess(1);
                e.onError(new RuntimeException("uuu"));
            }
        }).subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("maybe : onSuccess:" + o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("maybe : onError:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("maybe : oncomplete");
            }
        });



    }


    public static void test13(){
        
        
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> e) throws Exception {
                System.out.println("subscribe:" + getThreadName());
                e.onSuccess("123");
            }
        })
                .map(a -> {
            System.out.println("map:" + getThreadName());
            return a + "b";
        })
                .subscribeOn(newSchedulers("test"))
            .doOnSubscribe(a -> {
                System.out.println("doOnSubscribe:" + getThreadName());
                System.out.println(a);
            })
                .map(a -> {
                    System.out.println("map1:" + getThreadName());
                    return a + "b";
                })
                .subscribeOn(newSchedulers("test1"))
                .doOnSubscribe(a -> {
                    System.out.println("doOnSubscribe2:" + getThreadName());
                })
                .observeOn(newSchedulers("ooo"))
                .subscribe((a) -> {
                    System.out.println("subscribe:" + getThreadName());
                    System.out.println(a);
                });



    }


    public static void test14(){

        Subject.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                e.onNext(1);
                e.onComplete();
            }
        }).subscribe((a) -> {
//            System.out.println(a);
        });

        AsyncSubject.just(1, 2, 3).subscribe((a) -> {
//            System.out.println(a);
        });

        AsyncSubject subject = AsyncSubject.create();
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.onComplete();
        subject.subscribe((a) -> {
            System.out.println(a);
        });
        
    }

    public static Scheduler newSchedulers(String name){
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat(name + "_%s").build();
        return Schedulers.from(Executors.newFixedThreadPool(10, factory));
    }

    public static Scheduler newSchedulers1(String name){
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat(name + "_%s").build();
        return Schedulers.from(Executors.newCachedThreadPool(factory));
    }

    public static String getThreadName(){
        return Thread.currentThread().getName();
    }


}
