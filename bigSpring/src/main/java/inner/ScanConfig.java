package inner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/9/19.
 */
@Configuration
public class ScanConfig {

    @Bean
    public Scan scan(){


        Scan scan = new Scan();
        return scan;


    }


}
