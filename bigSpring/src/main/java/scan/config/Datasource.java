package scan.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/28.
 */
@Configuration
public class Datasource {

//
//    @Value("${datasource.driverClassName}")
//    private String driverClassName;
//
//    @Value("${datasource.url}")
//    private String url;
//
//    @Value("${datasource.username}")
//    private String username;
//
//    @Value("${datasource.password}")
//    private String password;

    @Bean
    public DataSource dataSource(){
        PooledDataSource pool = new PooledDataSource();
        pool.setDriver("com.mysql.cj.jdbc.Driver");
        pool.setUrl("jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE&useSSL=false&serverTimezone=UTC");
        pool.setUsername("root");
        pool.setPassword("root");
        pool.setPoolMaximumActiveConnections(5);
        return pool;
    }



}
