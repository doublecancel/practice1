package cn.spring.security.demo.entity;

import cn.spring.security.demo.common.Convert;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public class SpringUserDomain extends UserDomain implements UserDetails , Convert<SpringUserDomain, UserDomain> {

    List<GrantedAuthority> authorities = new ArrayList<>();
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;

    /**
     * 添加权限名称
     * @param roleName
     * @return
     */
    public SpringUserDomain  addAuthority(String roleName){
        authorities.add(new SimpleGrantedAuthority(roleName));
        return this;
    }

    /**
     * 清楚所有权限
     */
    public void clearAuthority(){
        authorities.clear();
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public UserDomain doForward(SpringUserDomain springUserDomain) {
        UserDomain domain = new UserDomain();
        BeanUtils.copyProperties(springUserDomain, domain);
        return domain;
    }

    @Override
    public SpringUserDomain doBackward(UserDomain domain) {
        SpringUserDomain springUserDomain = new SpringUserDomain();
        BeanUtils.copyProperties(domain, springUserDomain);
        return springUserDomain;
    }
}
