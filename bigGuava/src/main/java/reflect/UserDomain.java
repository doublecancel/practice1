package reflect;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */
@Data
public class UserDomain {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private Integer age;
    private List<RoleDomain> roles;
    private List<MenuDomain> menus;
    private UserType userType;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
