package cn.spring.security.demo.filter;

import cn.spring.security.demo.config.WeUserDetailsService;
import cn.spring.security.demo.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/10.
 * 拦截每一个请求
 */
public class LoginTokenFilter extends OncePerRequestFilter {


    private String header;

    JwtUtils jwtUtils;

    WeUserDetailsService weUserDetailsService;


    public LoginTokenFilter() {
    }

    public LoginTokenFilter(String header, JwtUtils jwtUtils, WeUserDetailsService weUserDetailsService) {
        this.header = header;
        this.jwtUtils = jwtUtils;
        this.weUserDetailsService = weUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(header);
        System.out.println(token);
        Map<String, Object> map =  jwtUtils.getClaims(token);
        if(map != null && SecurityContextHolder.getContext().getAuthentication() == null){

            String username = map.get("username").toString();
            String id = map.get("id").toString();

            UserDetails details = weUserDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    details, null, details.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }



}
