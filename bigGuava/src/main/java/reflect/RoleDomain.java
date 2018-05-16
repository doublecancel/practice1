package reflect;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/10/17.
 */
@Data
public class RoleDomain {
    private Long id;
    private String roleName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
