package test.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.entity.User;

/**
 * Created by Administrator on 2018/1/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    @Query("update User set name = :name where id = :id")
    @Modifying
    int update(@Param("name") String name, @Param("id") Long id);
}
