package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.model.entity.City;
import com.nocountry.inmuebles.repository.CityRepository;
import com.nocountry.inmuebles.service.abstraction.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public List<City> getAllCities(Long idProvince) {
        return cityRepository.findAllByProvinceIdOrderByDescriptionAsc(idProvince);
    }
}
