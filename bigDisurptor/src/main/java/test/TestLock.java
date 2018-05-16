package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class TestLock {


    ReentrantLock lock = new ReentrantLock();
    ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    CyclicBarrier barrier = new CyclicBarrier(1);
    CountDownLatch latch = new CountDownLatch(11);


    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        IntStream.range(1, 10).forEach(a -> {
            new Thread(() -> {
                testLock.testLock();
            }).start();
        });
    }

    public void testLock4(){
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

    public void testlock3(){
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public void testLock2(){
        lock1.readLock().lock();
        lock1.writeLock().lock();
        lock1.writeLock().unlock();
        lock1.readLock().unlock();
    }
    public void testLock (){
        try {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaaaaaaaaaaa");
        } finally {
            lock.unlock();
        }
    }



}
