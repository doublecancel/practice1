package repeatScan.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/2.
 */
@Component
public class UserController {


//    @RejectedX("version")
    @Autowired
    private IUserService userService;

    public void test(){
        System.out.println(userService.getUserName());
    }


}
