package springTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import springTest.config.TestConfig;
import springTest.service.RoleService;
import springTest.service.UserService;

/**
 * Created by Administrator on 2017/8/25.
 */


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class SpringTest {

    @Mock
    RoleService roleService;

    @Autowired
    UserService userService;


    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        Mockito.when(roleService.save()).thenReturn(10);

        Assert.assertEquals("result:", roleService.save(), 0);
    }





}
