package scan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/28.
 */
//@Configuration
public class TransConfig {

    @Autowired
    DataSource   dataSource;

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager1(){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager2(){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1(){
        JdbcTemplate template  = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate template  = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }


}
