package cn.spring.security.demo.handler;

import cn.spring.security.demo.common.Response;
import cn.spring.security.demo.entity.SpringUserDomain;
import cn.spring.security.demo.utils.JwtUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 * 登录成功处理器
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtUtils jwtUtils;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        log.debug("开始当前用户权限信息--------------------------");

        Object obj = authentication.getPrincipal();
        Preconditions.checkNotNull(obj, "登录信息异常");
        if(obj instanceof SpringUserDomain){
            SpringUserDomain user = (SpringUserDomain) obj;

            log.debug("当前登录用户信息：{}", new Gson().toJson(user));

            log.debug("开始设置token参数");

            String token = getToken(request, user);
            Response response1 = new Response();
            response1.setSuccess(true);
            response1.setMessage(token);
            response1.setCode(200);
            response.getWriter().write(new Gson().toJson(response1));
        }

    }

    private String getToken(HttpServletRequest request, SpringUserDomain domain){
        Map<String, Object> map = new HashMap<>();
        map.put(SpringUserDomain.Field.ID, domain.getId());
        map.put(SpringUserDomain.Field.USERNAME, domain.getUsername());
        map.put(SpringUserDomain.Field.EMAIL, domain.getEmail());
        map.put(SpringUserDomain.Field.PASSWORD, domain.getPassword());
        map.put("roles", Joiner.on("&").join(domain.getAuthorities()));

        return jwtUtils.generateToken(map);

    }

}
