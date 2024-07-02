package com.nocountry.inmuebles.controller;

import com.nocountry.inmuebles.model.entity.PropertyType;
import com.nocountry.inmuebles.service.abstraction.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property_type")

@RequiredArgsConstructor
public class PropertyTypeController {
    private final PropertyTypeService propertyTypeService;

    @GetMapping
    public List<PropertyType> getAllPropertyType(){
        return propertyTypeService.getAllPropertyTypes();
    }
}
