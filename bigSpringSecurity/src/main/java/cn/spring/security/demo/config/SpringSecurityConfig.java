package cn.spring.security.demo.config;

import cn.spring.security.demo.filter.LoginFilter;
import cn.spring.security.demo.filter.LoginTokenFilter;
import cn.spring.security.demo.handler.WeAccessDeniedHandler;
import cn.spring.security.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Administrator on 2017/11/3.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)//添加方法级别的验证
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ApplicationContext ac;

    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;//登录成功处理器
    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;//登录失败处理器

    @Value("${jwt.header}")
    private String header;

    @Autowired
    JwtUtils jwtUtils;

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();//只能在此实例化，无法使用spring容器
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        loginFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return loginFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build()
        );
        manager.createUser(User
                .withUsername("user")
                .password("user")
                .roles("USER")
                .build()
        );

        manager.createUser(User
                .withUsername("lxl")
                .password("123456")
                .roles("USER", "ADMIN")
                .build()
        );
        return manager;
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //------------登录配置
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();
        http
                .addFilter(loginFilter())
                .formLogin()
                .and()
//
//                                .logout() //无法使用登出配置
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .logoutSuccessUrl("")
//                .addLogoutHandler(new WeLogoutHandler())
//
//                .and()

                .authorizeRequests()
                .antMatchers("/all/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/any/**").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/both/**").access("hasRole('ADMIN') and hasRole('USER')")
                .antMatchers(
                        HttpMethod.GET,
                        "/", "/*.html", "/favicon.ico",  "/**/*.html",
                        "/**/*.css", "/**/*.js"
                ).permitAll()
                .anyRequest().authenticated();

        http.csrf().disable()
        .exceptionHandling().accessDeniedHandler(new WeAccessDeniedHandler())
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//不创建session
                ;

        http.headers().cacheControl();//disable page cache

        http.addFilterBefore(new LoginTokenFilter(header, jwtUtils, weUserDetailsService), UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    WeUserDetailsService weUserDetailsService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new SimplePasswordEncoder());
        provider.setUserDetailsService(weUserDetailsService);
        return provider;
    }


}
