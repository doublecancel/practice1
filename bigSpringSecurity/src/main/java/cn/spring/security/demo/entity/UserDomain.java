package cn.spring.security.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

/**
* Created by Administrator on 2017-11-01 14:25:34
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：cloud.user
*/
public class UserDomain {

    private Long id;//

    private String sid;//

    private String username;//

    private String password;//

    private String realname;//

    private String phone;//

    private String email;//

    private String address;//

    private Integer age;//

    private Integer gender;//
    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime last_login_date;//
    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime create_date;//
    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime modify_date;//

    private Integer status;//

    private Integer version;//



    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setSid(String sid){
        this.sid = sid;
    }
    public String getSid(){
        return this.sid;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setRealname(String realname){
        this.realname = realname;
    }
    public String getRealname(){
        return this.realname;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setGender(Integer gender){
        this.gender = gender;
    }
    public Integer getGender(){
        return this.gender;
    }
    public void setLast_login_date(LocalDateTime last_login_date){
        this.last_login_date = last_login_date;
    }
    public LocalDateTime getLast_login_date(){
        return this.last_login_date;
    }
    public void setCreate_date(LocalDateTime create_date){
        this.create_date = create_date;
    }
    public LocalDateTime getCreate_date(){
        return this.create_date;
    }
    public void setModify_date(LocalDateTime modify_date){
        this.modify_date = modify_date;
    }
    public LocalDateTime getModify_date(){
        return this.modify_date;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getStatus(){
        return this.status;
    }
    public void setVersion(Integer version){
        this.version = version;
    }
    public Integer getVersion(){
        return this.version;
    }

    //------------------------------------------------------------------------------
    public UserDomain id(Long id){
        this.id = id;
        return this;
    }
    public UserDomain sid(String sid){
        this.sid = sid;
        return this;
    }
    public UserDomain username(String username){
        this.username = username;
        return this;
    }
    public UserDomain password(String password){
        this.password = password;
        return this;
    }
    public UserDomain realname(String realname){
        this.realname = realname;
        return this;
    }
    public UserDomain phone(String phone){
        this.phone = phone;
        return this;
    }
    public UserDomain email(String email){
        this.email = email;
        return this;
    }
    public UserDomain address(String address){
        this.address = address;
        return this;
    }
    public UserDomain age(Integer age){
        this.age = age;
        return this;
    }
    public UserDomain gender(Integer gender){
        this.gender = gender;
        return this;
    }
    public UserDomain last_login_date(LocalDateTime last_login_date){
        this.last_login_date = last_login_date;
        return this;
    }
    public UserDomain create_date(LocalDateTime create_date){
        this.create_date = create_date;
        return this;
    }
    public UserDomain modify_date(LocalDateTime modify_date){
        this.modify_date = modify_date;
        return this;
    }
    public UserDomain status(Integer status){
        this.status = status;
        return this;
    }
    public UserDomain version(Integer version){
        this.version = version;
        return this;
    }

    //----------------------------------------------------------------------------------
    public static class Field {
        public static final String ID = "id";
        public static final String SID = "sid";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String REALNAME = "realname";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String AGE = "age";
        public static final String GENDER = "gender";
        public static final String LAST_LOGIN_DATE = "last_login_date";
        public static final String CREATE_DATE = "create_date";
        public static final String MODIFY_DATE = "modify_date";
        public static final String STATUS = "status";
        public static final String VERSION = "version";
    }



}