package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.UserRepository;
import test.entity.User;

import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2018/1/16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        throw new RuntimeException("");
//       return userRepository.save(user) ;
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findOne(1L);

    }

    @Transactional(rollbackFor = Exception.class)
    public int update(String name) throws FileNotFoundException {
        userRepository.update(name, 1L);
        try {
            userRepository.findOne(100L).getCreate_date();//npe rollback
        }catch (Exception e){
            e.printStackTrace();
        }
//        FileInputStream is = new FileInputStream(new File(""));//not rollback, 使用try catch时无法回滚，将throws加到方法上才执行回滚

        return 1;
    }

    public final int update2(String name) {
        return userRepository.update(name, 1L);
    }
}
