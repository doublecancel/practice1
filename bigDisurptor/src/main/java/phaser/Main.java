package phaser;

import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        phaser.bulkRegister(4);
        IntStream.range(1, 5)
                .forEach(a -> {

                    Student s = new Student("学生" + a, phaser);
                    new Thread(s).start();


                });
    }


}
