package test;

import java.util.concurrent.Semaphore;

public class SamTest {


    private Semaphore semaphore = new Semaphore(2);


    public static void main(String[] args) {

    }

    public void testSam(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }


}
