package phaser;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser{


    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0 : {
                System.out.println("全部学生到达教室");
                return false;
            }
            case 1 : {
                System.out.println("全部学生完成第一题");
                return false;
            }
            case 2 : {
                System.out.println("全部学生完成第二题");
                return false;
            }
            case 3 : {
                System.out.println("全部学生完成第三题");
                return false;
            }
            case 4 : {
                System.out.println("全部学生完成第四题");
                return false;
            }
            case 5 : {
                System.out.println("全部学生完成");
                return true;
            }
            default: return true;
        }
    }
}
