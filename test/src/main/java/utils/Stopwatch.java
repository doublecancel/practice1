package utils;

public class Stopwatch {

    private Stopwatch(){}


    public static Stopwatch create(){
        return new Stopwatch();
    }

    private Long start = System.currentTimeMillis();

    public Long reset(){
        try{
            return  System.currentTimeMillis() - start;
        }finally {
            start = System.currentTimeMillis();
        }
    }

    public void resetAndLog(String message){
        System.out.println(message + " execute time:" + reset());
    }


}
