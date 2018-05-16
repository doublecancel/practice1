package cn.spring.security.demo.service;

import cn.spring.security.demo.entity.UserDomain;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class UserServiceImpl extends AbstractBaseService<UserDomain, Long> implements IUserService {
}
