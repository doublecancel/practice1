package com.example.learn.dao;

import com.example.learn.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class CityDaoImpl implements CityDao {


    @Autowired
    JdbcTemplate template;


    @Override
    @Transactional
    public City save() {
        template.execute("INSERT INTO city (`name`, `desc`, status) VALUES ('aaa', 'bbb', 1)");
        throw new RuntimeException("aaa");
//        return new City();
    }

    @Override
//    @Transactional
    public City findById(Long id) {
        List<City> list =  template.query("select * from city a where a.id = ?", new Object[]{id}, (r, n) -> {
            City city = new City();
            city.setId(r.getLong("id"));
            city.setDesc(r.getString("desc"));
            city.setName(r.getString("name"));
            city.setStatus(r.getInt("status"));

            return city;
        });

        if(list == null || list.size() == 0){
            return null;
        }

        throw new RuntimeException("abc");

//        return list.get(0);
    }


    @Override
    public void test() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
