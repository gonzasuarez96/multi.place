package com.nocountry.inmuebles.model.mapper;

import com.nocountry.inmuebles.model.entity.*;
import com.nocountry.inmuebles.model.request.PropertyRequest;
import com.nocountry.inmuebles.model.response.PropertyResponse;

public interface PropertyMapper {
    /**
     * DtoAddress to Entity
     * @param address DTO Address
     * @return Entity Address
     */
    Address toEntityAddress(DTOAddress address);

    /**
     * Entity Address to Dto
     * @param entity Entity Address
     * @return Dto Address
     */
    DTOAddress toDtoAddress(Address entity);

    /**
     * DtoProperty to Entity
     * @param dto DTO property
     * @return Entity Property
     */
    Property toEntity(DTORegisterProperty dto);

    /**
     * Entity Propery to DtoProperty
     * @param entity Entity Property
     * @return Dto Property
     */
    // Entity ---> DTO
    DTORegisterProperty toDto(Property entity);
    //DTOcity ---> city entidad
    City toEntityCity(DTOCity dtoCity);
    //City --> DTOCity
    DTOCity toDtoCity(City city);
    //DTOProvince ---> province entidad
    Province toEntityProvince(DTOProvince dtoProvince);
    //Province ---> DTOProvince
    DTOProvince toDtoProvince(Province province);
    //DTOImage ---> Image
    Image toEntityImage(DTOImage dtoImage);
    //Image ---> DtoImage
    DTOImage toDtoImage(Image image);
    //DTOPropertyType --> PropertyType
    PropertyType toEntityPropertyType(DTOPropertyType dtoPropertyType);
    //PropertyType --> DTOPropertyType
    DTOPropertyType toDtoPropertyType(PropertyType propertyType);
    //DTOUser --> User
    User toEntityUser(DTOUser dtoUser);
    //User --> DTOUser
    DTOUser toDtoUser(User user);
    Property requestToProperty(PropertyRequest propertyRequest);
    PropertyResponse propertyToResponse(Property entity);
    Property updateProperty(Property property, PropertyRequest propertyRequest);
}
