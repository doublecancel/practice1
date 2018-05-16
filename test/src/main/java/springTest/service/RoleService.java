package springTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springTest.dao.UserDao;

/**
 * Created by Administrator on 2017/8/25.
 */
@Component
public class RoleService {

    @Autowired(required = false)
    UserDao userDao;

    public int save(){
        return userDao.save();
    }
}
