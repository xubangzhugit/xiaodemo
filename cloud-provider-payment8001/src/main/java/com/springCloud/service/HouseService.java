package com.springCloud.service;

import com.springCloud.pojo.House;

public interface HouseService {

    public int create(House house);
    public House getHouseById(Integer id);
}
