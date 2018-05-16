package reflect;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/10/17.
 */
@Data
public class MenuDomain {
    private Long id;
    private String menuName;
    private Integer type;
    private Integer level;
    private Long parent_id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
