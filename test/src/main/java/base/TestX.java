package base;

import utils.Stopwatch;

import java.util.stream.IntStream;

public class TestX {


    static final Stopwatch stopwatch = Stopwatch.create();

    public static void main(String[] args) {

//        test1();
//        test2();
        IntStream.range(1, 10000).forEach(a -> {
            System.out.println(a % 8 == (a & (8 - 1)));
        });


    }



    public static void test1(){
        stopwatch.reset();
        IntStream.range(1, 100000).forEach(a -> {
            boolean flag = (a % 2 == 0);
        });
        stopwatch.resetAndLog("%");

        IntStream.range(1, 100000).forEach(a -> {
            boolean flag = ((a & 1) != 1);
        });
        stopwatch.resetAndLog("&");
    }

    public static void test2(){

        System.out.println(1 << 16);

        CountHolder holder = new CountHolder();
        holder.addType1(20206);
        holder.addType2(15963);

        System.out.println(holder.getType1());
        System.out.println(holder.getType2());

    }

    public static class CountHolder {
        int state = 0;

        public CountHolder(){
            this.state = 0;
        }

        public void addState(int state){
            this.state += state;
        }

        public void addType1(int a){
            addState((1 << 16) * a);
        }
        public void addType2(int b){
            addState(b);
        }

        public int getType2(){
            return this.state & ((1 << 16) - 1);
        }
        public int getType1(){
            return this.state >>> 16;
        }

    }

}
