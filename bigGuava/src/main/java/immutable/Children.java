package immutable;

public class Children  extends Parent{


    static {
        System.out.println("children static块");
    }

    static {
        System.out.println("children 普通块");
    }

    static int a ;
    int b;

    public Children(){
        System.out.println("children 构造方法");
    }

    public static void main(String[] args) {
        new Children();
    }

}
