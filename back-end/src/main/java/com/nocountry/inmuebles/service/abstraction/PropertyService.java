package com.nocountry.inmuebles.service.abstraction;

import com.nocountry.inmuebles.model.entity.City;
import com.nocountry.inmuebles.model.mapper.DTORegisterProperty;
import com.nocountry.inmuebles.model.request.PropertyRequest;
import com.nocountry.inmuebles.model.response.PropertyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PropertyService {
    Page<PropertyResponse> findAll(String province, String city, Boolean noted,String type,
                                   Double minimumPrice,Double maximumPrice,Integer bedrooms,
                                   Integer bathrooms,Integer minimumSquareMeter,Integer maximumSquareMeter,
                                   Boolean state,String contractType,Pageable pageable);
    PropertyResponse createProperty(List<MultipartFile> file, PropertyRequest propertyRequest);
    List<PropertyResponse> getAll();
    PropertyResponse getById(Long id);
    void update(Long id, PropertyRequest propertyRequest) throws Exception;
    void delete(Long id);
}
