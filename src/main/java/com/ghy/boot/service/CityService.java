package com.ghy.boot.service;

import com.ghy.boot.bean.City;
import com.ghy.boot.mapper.CityMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityById(Long id){
        return cityMapper.getCityById(id);
    }

    public void saveCity(City city){
        cityMapper.insertCity(city);
    }
}
