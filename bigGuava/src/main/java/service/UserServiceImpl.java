package service;

import limiter.Limiter;

/**
 * Created by Administrator on 2017/12/8.
 */
public class UserServiceImpl implements IUserService {
    @Override
    @Limiter(1)
    public String findNameByid(Long id) {
        return "user";
    }

    @Override
    public String toString() {
        return "UserServiceImpl";
    }
}
