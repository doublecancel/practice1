package cn.spring.security.demo.config;

import cn.spring.security.demo.common.InncorrectPasswordException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Administrator on 2017/11/6.
 * 自定义加密和解密器
 */
public class SimplePasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            return super.matches(rawPassword, encodedPassword);
        }catch (Exception e){
            throw InncorrectPasswordException.create("密码错误");
        }
    }
}
