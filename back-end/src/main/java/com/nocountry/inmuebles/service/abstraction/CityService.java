package com.nocountry.inmuebles.service.abstraction;

import com.nocountry.inmuebles.model.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities(Long idProvince);
}
