package com.springCloud.Dao;

import com.springCloud.pojo.House;

public interface HouseDao {

    public int create(House house);
    public House getHouseById(Integer id);
}
