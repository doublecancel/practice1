package cn.spring.security.demo.handler;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/3.
 */
@Component("myAuthenticationManager")
public class MyAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("执行登录逻辑");
        return null;
    }
}
