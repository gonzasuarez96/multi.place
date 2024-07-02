package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.model.entity.Province;
import com.nocountry.inmuebles.repository.ProvinceRepository;
import com.nocountry.inmuebles.service.abstraction.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;
    @Override
    public List<Province> getAllProvinces() {
        return provinceRepository.findAllByOrderByDescriptionAsc();
    }
}
