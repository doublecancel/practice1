package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConditionTest {


    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new ConditionTest().test();

    }

    public void test(){
        IntStream.range(1, 3) .forEach(a -> {

            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    condition.await(4L, TimeUnit.SECONDS);
                    System.out.println("线程：" + Thread.currentThread().getName() + "，继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();

        });

        System.out.println("等待3秒");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            condition.signalAll();//唤醒所有
            lock.unlock();
        }).start();


    }



}
