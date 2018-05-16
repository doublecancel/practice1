package test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.App;
import test.entity.User;
import test.service.UserService;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Administrator on 2018/1/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void test() {

        User user = new User();
        user.setCreate_date(LocalDateTime.now());

        user.setEmail("liuxianglei@UCPAAS.COM   ");
        user.setGender(1);
        user.setLast_login_date(LocalDateTime.now());
        user.setMobile("13120971538");
        user.setName("lxl");

        User newUser = userRepository.save(user);
        System.out.println(newUser.toString());
        Assert.assertEquals(user, newUser);
    }

    @Test
    public void testTransaction() {
        User user = userService.findById(1L);
        User user1 = new User();

        user1.setCreate_date(LocalDateTime.now());

        user1.setEmail("liuxianglei@UCPAAS.COM   ");
        user1.setGender(1);
        user1.setLast_login_date(LocalDateTime.now());
        user1.setMobile("13120971538");
        user1.setName("lxl");
        System.out.println(user.toString());
        Assert.assertTrue(Objects.equals(user, user1));

    }

    @Test
    public void update1()throws Exception{
        int res = userService.update("test1");
        Assert.assertEquals(res, 1);

    }

    @Test
    public void update2()throws Exception{
        int res  = userService.update2("test2");
        Assert.assertEquals(res, 1);
    }
}
