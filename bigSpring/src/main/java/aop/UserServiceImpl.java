package aop;

/**
 * Created by Administrator on 2017/9/25.
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void sayHello() {
        System.out.println("OK");
    }
}
