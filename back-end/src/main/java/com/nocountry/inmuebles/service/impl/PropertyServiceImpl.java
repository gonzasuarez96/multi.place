package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.InmueblesApplication;
import com.nocountry.inmuebles.exception.NotFoundException;
import com.nocountry.inmuebles.model.entity.*;
import com.nocountry.inmuebles.model.mapper.DTORegisterProperty;
import com.nocountry.inmuebles.model.mapper.PropertyMapper;
import com.nocountry.inmuebles.model.request.PropertyRequest;
import com.nocountry.inmuebles.model.response.PropertyResponse;
import com.nocountry.inmuebles.repository.*;
import com.nocountry.inmuebles.service.abstraction.AwsService;
import com.nocountry.inmuebles.service.abstraction.PropertyService;
import com.nocountry.inmuebles.util.PropertySpecification;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final CityRepository cityRepository;
    private final PropertyTypeRepository propertyTypeRepository;
    private final ProvinceRepository provinceRepository;
    private final UserRepository userRepository;
    private final PropertyMapper propertyMapper;
    private final AwsService awsService;
    @Override
    public Page<PropertyResponse> findAll(String province, String city, Boolean noted,String type , Double minimumPrice,
                                          Double maximumPrice,Integer bedrooms,Integer bathrooms,Integer minimumSquareMeter,
                                          Integer maximumSquareMeter,Boolean state,String contractType,Pageable pageable) {

        PropertySpecification specification = new PropertySpecification(noted,province,city,type,minimumPrice,maximumPrice,
                                                                        bedrooms,bathrooms,minimumSquareMeter,maximumSquareMeter,
                                                                        state,contractType);

        Page<PropertyResponse> response =propertyRepository.findAll(specification,pageable).map(propertyMapper::propertyToResponse);

        if(response.isEmpty())
            throw new NotFoundException("There are no properties with these filters");

        return response;
    }

    @Override
    public PropertyResponse createProperty(List<MultipartFile> file, PropertyRequest propertyRequest){
        try {
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            Property property = propertyMapper.requestToProperty(propertyRequest);
            City city = cityRepository.findById(propertyRequest.getCity_id()).orElseThrow();
            PropertyType propertyType = propertyTypeRepository.findById(propertyRequest.getProperty_type_id()).orElseThrow();
            Province province = provinceRepository.findById(propertyRequest.getProvince_id()).orElseThrow();
            User user = userRepository.findById(propertyRequest.getUser_id()).orElseThrow();
            property.setCity(city);
            property.setProperty_type(propertyType);
            property.setProvince(province);
            property.setUser_registration(user);
            property.setProperty_image(awsService.uploadImage(file, property));
            property.setRegistration_date(currentDate.toString());
            property.setRegistration_time(currentTime.toString());
            property.setState(true);
            Property propertySaved = propertyRepository.save(property);
            PropertyResponse propertyResponse = propertyMapper.propertyToResponse(propertySaved);
            return propertyResponse;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Algunos elementos no se encontraron en la base de datos.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PropertyResponse> getAll() {
        return propertyRepository.findAll().stream()
                .map(propertyMapper::propertyToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyResponse getById(Long id) {
        return propertyMapper.propertyToResponse(propertyRepository.getById(id));
    }

    @Override
    public void update(Long id, PropertyRequest propertyRequest) throws Exception {
        try{
            Property property = propertyRepository.getById(id);
            City city = cityRepository.findById(propertyRequest.getCity_id()).orElseThrow();
            PropertyType propertyType = propertyTypeRepository.findById(propertyRequest.getProperty_type_id()).orElseThrow();
            Province province = provinceRepository.findById(propertyRequest.getProvince_id()).orElseThrow();
            User user = userRepository.findById(propertyRequest.getUser_id()).orElseThrow();
            property.setCity(city);
            property.setProperty_type(propertyType);
            property.setProvince(province);
            property.setUser_registration(user);
            propertyRepository.save(propertyMapper.updateProperty(property, propertyRequest));
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Algunos elementos no se encontraron en la base de datos.");
        }catch (Exception e){
            throw new Exception("Se produjo un error durante la actualización de la propiedad.");
        }
    }

    @Override
    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }
}
