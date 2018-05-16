package cn.spring.security.demo.config;

import cn.spring.security.demo.common.ParamsMap;
import cn.spring.security.demo.dao.UserDao;
import cn.spring.security.demo.entity.SpringUserDomain;
import cn.spring.security.demo.entity.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
@Component
public class WeUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    /**
     * 需要在此查询权限信息，因为在token验证时需要
     * TODO 将该方法加入缓存，提高每次响应的速度
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDomain> domains =  userDao.findAllByCondition(ParamsMap.create().push(UserDomain.Field.USERNAME, username));
        if(domains == null || domains.size() == 0){
            throw new UsernameNotFoundException("找不到用户信息");
        }
        UserDomain domain = domains.get(0);

        SpringUserDomain springUserDomain = new SpringUserDomain().doBackward(domain);

        return springUserDomain;
    }


}
