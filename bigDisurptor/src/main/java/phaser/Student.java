package phaser;

import java.util.concurrent.Phaser;

public class Student implements Runnable{

    String name;
    Phaser phaser;

    public Student(String name , Phaser phaser){
        super();
        this.name = name;
        this.phaser = phaser;
    }



    @Override
    public void run() {
        System.out.println(name + "到达教室");
        phaser.arriveAndAwaitAdvance();//到达并且等待

        System.out.println(name + "开始做第一题");
        phaser.arriveAndAwaitAdvance();//到达并且等待

        System.out.println(name + "开始做第二题");
        phaser.arriveAndAwaitAdvance();//到达并且等待

        System.out.println(name + "开始做第三题");
        phaser.arriveAndAwaitAdvance();//到达并且等待

        System.out.println(name + "开始做第四题");
        phaser.arriveAndAwaitAdvance();//到达并且等待

        System.out.println(name + "结束考试");
        phaser.arriveAndAwaitAdvance();//到达并且等待
    }
}
