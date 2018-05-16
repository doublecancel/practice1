package test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2018/1/15.
 */
@EnableJpaRepositories(basePackages = "test.dao")
@Configuration
@EnableTransactionManagement
public class JpaConfig {


}
