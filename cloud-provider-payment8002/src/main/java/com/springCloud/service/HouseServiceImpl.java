package com.springCloud.service;

import com.springCloud.Dao.HouseDao;
import com.springCloud.pojo.House;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HouseServiceImpl implements HouseService{

  @Resource
  private HouseDao houseDao;

    @Override
    public int create(House house) {
        return houseDao.create(house);
    }

    @Override
    public House getHouseById(Integer id) {
        return houseDao.getHouseById(id);
    }
}
