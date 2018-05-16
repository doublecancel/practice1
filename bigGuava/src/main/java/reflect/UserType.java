package reflect;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/10/17.
 */
@Data
public class UserType {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
