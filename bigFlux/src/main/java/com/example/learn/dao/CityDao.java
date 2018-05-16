package com.example.learn.dao;

import com.example.learn.entity.City;

public interface CityDao {


    City save();

    City findById(Long id);


    void test();
}
