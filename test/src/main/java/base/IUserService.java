package base;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public interface IUserService {

    int save();

    void delete();

    User findById(Long id);

    List<User> listUser();

    User update(User u);

}
