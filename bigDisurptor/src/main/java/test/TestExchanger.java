package test;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class TestExchanger {

    private Exchanger<List<String>> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        TestExchanger bean = new TestExchanger();
        bean.send();
        bean.receive();
    }

    public void send(){

        new Thread(() -> {
            List<String> list = new ArrayList<>();
            list.add("a");
            list.add("b");
            list.add("c");
            try {
                System.out.println("thread:" + Thread.currentThread().getName() + "  start ------------");
                System.out.println("thread:" + Thread.currentThread().getName() + "  end ------------");
                System.out.println("发送的数据是：a, b, c");
                exchanger.exchange(list);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void receive(){
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            try {
                System.out.println("thread:" + Thread.currentThread().getName() + "  start ------------");
                exchanger.exchange(list);
                System.out.println("thread:" + Thread.currentThread().getName() + "  end ------------");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("接受到的数据是：" + Joiner.on(",").join(list));

        }).start();
    }

}
