package cn.spring.security.demo.filter;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/11/3.
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException( "Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        User user = getUser(request);
        if (username == null) {
            username = user.getUsername();
        }

        if (password == null) {
            password = user.getPassword();
        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    private User getUser(HttpServletRequest request) {
        BufferedReader reader = null;
        InputStreamReader reader1 = null;
        try {
            reader1 = new InputStreamReader(request.getInputStream());
            reader = new BufferedReader(reader1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new Gson().fromJson(reader, User.class);
        return user;
    }

    @Data
    public class User {

        private String username;
        private String password;
    }

}
