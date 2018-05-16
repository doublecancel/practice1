package cn.spring.security.demo.common;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface Convert<A, B> {
    B doForward(A a);
    A doBackward(B b);
}
