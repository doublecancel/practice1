package scan.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/9/28.
 */
@Component
@Data
public class User {
    private String id;
    private String username;
    private String password;

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
}
