package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.model.entity.PropertyType;
import com.nocountry.inmuebles.repository.PropertyTypeRepository;
import com.nocountry.inmuebles.service.abstraction.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements PropertyTypeService {
    private final PropertyTypeRepository propertyTypeRepository;
    public List<PropertyType> getAllPropertyTypes(){
        return propertyTypeRepository.findAll();
    }
}
