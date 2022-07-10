package com.ghy.boot.service;
import com.ghy.boot.bean.City;
import com.ghy.boot.mapper.CityMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    Counter counter;
    public CityServiceImpl(MeterRegistry meterRegistry){
        //cityService的getCityById()被调用的次数
        counter = meterRegistry.counter("cityService.getCityById.count");
    }
    public City getCityById(Long id){
        counter.increment();
        return cityMapper.getCityById(id);
    }

    public void saveCity(City city){
        cityMapper.insertCity(city);
    }
}
