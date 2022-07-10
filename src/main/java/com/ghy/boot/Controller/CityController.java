package com.ghy.boot.Controller;

import com.ghy.boot.bean.City;
import com.ghy.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getCityById(id);
    }

    @ResponseBody
    @PostMapping("/save")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }
}
