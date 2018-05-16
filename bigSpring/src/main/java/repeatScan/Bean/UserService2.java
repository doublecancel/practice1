package repeatScan.Bean;

import org.springframework.stereotype.Service;
import repeatScan.annotation.Version;

/**
 * Created by Administrator on 2017/11/2.
 */
@Service
@Version(2)
public class UserService2 implements IUserService {

    @Override
    public String getUserName() {
        return "new user name";
    }
}
