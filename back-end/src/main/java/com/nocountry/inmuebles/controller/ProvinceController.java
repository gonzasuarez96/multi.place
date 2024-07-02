package com.nocountry.inmuebles.controller;

import com.nocountry.inmuebles.model.entity.Province;
import com.nocountry.inmuebles.service.abstraction.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/province")

@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;
    @GetMapping
    public List<Province> getAllProvinces(){
        return provinceService.getAllProvinces();
    }
}
