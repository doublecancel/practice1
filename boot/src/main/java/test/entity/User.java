package test.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2018/1/15.
 */
@Entity
@Table(name = "user")
@Data
public class User {


    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "last_login_date")
    private LocalDateTime last_login_date;
    @Column(name = "create_date")
    private LocalDateTime create_date;
    @Column(name = "status")
    private Integer status;
    @Column(name = "version")
    private Integer version;
    @Column(name = "gender")
    private Integer gender;

}
