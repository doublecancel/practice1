package scan.dao;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/28.
 */
//@Service
public class UserDao {



    @Transactional(transactionManager = "dataSourceTransactionManager1")
    public void test1(){

    }

    @Transactional(transactionManager = "dataSourceTransactionManager2")
    public void test2(){

    }



}
