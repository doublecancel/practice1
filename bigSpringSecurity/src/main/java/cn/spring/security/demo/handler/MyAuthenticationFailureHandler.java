package cn.spring.security.demo.handler;

import cn.spring.security.demo.common.Response;
import com.google.gson.Gson;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/11/3.
 * 自定义登录失败处理器
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        response.setStatus(401);

        Response response1 = new Response();
        response1.setCode(401);
        String message = "";
        if(exception instanceof BadCredentialsException){
            message = "密码错误";
        } else {
            message = exception.getMessage();
        }
        response1.setMessage(message);
        response1.setSuccess(false);
        pw.write(new Gson().toJson(response1));
        response.flushBuffer();
    }
}
