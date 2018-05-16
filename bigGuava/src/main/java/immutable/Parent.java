package immutable;

public class Parent {

    static {
        System.out.println("parent static块");
    }

    {
        System.out.println("parent普通块");
    }

    public Parent(){
        System.out.println("parent 构造方法");
    }
}
