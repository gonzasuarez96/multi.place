package com.nocountry.inmuebles.model.mapper;


import com.nocountry.inmuebles.model.entity.*;
import com.nocountry.inmuebles.model.request.PropertyRequest;
import com.nocountry.inmuebles.model.response.PropertyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class PropertyMapperImpl implements PropertyMapper{
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public Address toEntityAddress(DTOAddress address) {
        return Address.builder()
                .street(address.street())
                .number(address.number())
                .complement(address.complement())
                .location_len(address.locationLen())
                .location_lat(address.locationLat())
                .build();
    }
    @Override
    public DTOAddress toDtoAddress(Address entity) {
        return DTOAddress.builder()
                .street(entity.getStreet())
                .number(entity.getNumber())
                .complement(entity.getComplement())
                .locationLat(entity.getLocation_lat())
                .locationLen(entity.getLocation_len())
                .build();
    }
    @Override
    public Property toEntity(DTORegisterProperty dto) {
        return Property.builder()
                .id(dto.id())
                .property_type(toEntityPropertyType(dto.property_type_id()))
                .address(toEntityAddress(dto.address()))
                .province(toEntityProvince(dto.province()))
                .city(toEntityCity(dto.city()))
                .price(dto.price())
                .square_meter(dto.squareMeter())
                .bedrooms(dto.bedrooms())
                .bathrooms(dto.bathrooms())
                .contract_type(dto.contractType())
                .state(dto.state())
                .user_registration(toEntityUser(dto.userRegistration()))
                .property_image(dto.propertyImage().stream()
                        .map(i -> toEntityImage(i))
                        .collect(Collectors.toList()))
                .registration_date(dto.registrationDate())
                .registration_time(dto.registrationTime())
                .name(dto.name())
                .description(dto.description())
                .noted(dto.noted())
                .build();
    }
    @Override
    public DTORegisterProperty toDto(Property entity) {
        return DTORegisterProperty.builder()
                .id(entity.getId())
                .property_type_id(toDtoPropertyType(entity.getProperty_type()))
                .address(toDtoAddress(entity.getAddress()))
                .province(toDtoProvince(entity.getProvince()))
                .city(toDtoCity(entity.getCity()))
                .price(entity.getPrice())
                .squareMeter(entity.getSquare_meter())
                .bedrooms(entity.getBedrooms())
                .bathrooms(entity.getBathrooms())
                .contractType(entity.getContract_type())
                .state(entity.getState())
                .userRegistration(toDtoUser(entity.getUser_registration()))
                .propertyImage(entity.getProperty_image().stream()
                        .map(image -> toDtoImage(image))
                        .collect(Collectors.toList()))
                .registrationDate(entity.getRegistration_date())
                .registrationTime(entity.getRegistration_time())
                .name(entity.getName())
                .description(entity.getDescription())
                .noted(entity.getNoted())
                .build();
    }

    @Override
    public City toEntityCity(DTOCity dtoCity) {
        return City.builder()
                .id(dtoCity.id())
                .description(dtoCity.description())
                .province(toEntityProvince(dtoCity.province()))
                .properties(dtoCity.properties().stream()
                        .map(p -> toEntity(p))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public DTOCity toDtoCity(City city) {
        return DTOCity.builder()
                .id(city.getId())
                .province(toDtoProvince(city.getProvince()))
                .properties(city.getProperties().stream()
                        .map(property -> toDto(property))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public DTOProvince toDtoProvince(Province province) {
        return DTOProvince.builder()
                .id(province.getId())
                .description(province.getDescription())
                .cities(province.getCities().stream()
                        .map(c -> toDtoCity(c))
                        .collect(Collectors.toList()))
                .properties(province.getProperties().stream()
                        .map(property -> toDto(property))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public Province toEntityProvince(DTOProvince dtoProvince) {
        return Province.builder()
                .id(dtoProvince.id())
                .description(dtoProvince.description())
                .cities(dtoProvince.cities().stream()
                        .map(c -> toEntityCity(c))
                        .collect(Collectors.toList()))
                .properties(dtoProvince.properties().stream()
                        .map(property -> toEntity(property))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public Image toEntityImage(DTOImage dtoImage) {
        return Image.builder()
                .id(dtoImage.id())
                .route(dtoImage.route())
                .property(toEntity(dtoImage.property()))
                .build();
    }

    @Override
    public DTOImage toDtoImage(Image image) {
        return DTOImage.builder()
                .id(image.getId())
                .route(image.getRoute())
                .property(toDto(image.getProperty()))
                .build();
    }
    @Override
    public PropertyType toEntityPropertyType(DTOPropertyType dtoPropertyType) {
        return PropertyType.builder()
                .id(dtoPropertyType.id())
                .description(dtoPropertyType.description())
                .properties(dtoPropertyType.properties().stream()
                        .map(p -> toEntity(p))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public DTOPropertyType toDtoPropertyType(PropertyType propertyType) {
        return DTOPropertyType.builder()
                .id(propertyType.getId())
                .description(propertyType.getDescription())
                .properties(propertyType.getProperties().stream()
                        .map(p -> toDto(p))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public User toEntityUser(DTOUser dtoUser) {
        return User.builder()
                .id(dtoUser.id())
                .name(dtoUser.name())
                .last_name(dtoUser.last_name())
                .email(dtoUser.email())
                .password(dtoUser.password())
                .property(dtoUser.property().stream()
                        .map(p->toEntity(p))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public DTOUser toDtoUser(User user) {
        return DTOUser.builder()
                .id(user.getId())
                .name(user.getName())
                .last_name(user.getLast_name())
                .email(user.getEmail())
                .password(user.getPassword())
                .property(user.getProperty().stream()
                        .map(p->toDto(p))
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public Property requestToProperty(PropertyRequest propertyRequest) {
        return Property.builder()
                .address(Address.builder()
                        .street(propertyRequest.getAddress().getStreet())
                        .number(propertyRequest.getAddress().getNumber())
                        .complement(propertyRequest.getAddress().getComplement())
                        .location_lat(propertyRequest.getAddress().getLocation_lat())
                        .location_len(propertyRequest.getAddress().getLocation_len())
                        .build())
                .price(propertyRequest.getPrice())
                .square_meter(propertyRequest.getSquare_meter())
                .bedrooms(propertyRequest.getBedrooms())
                .bathrooms(propertyRequest.getBathrooms())
                .contract_type(propertyRequest.getContract_type())
                //.state(propertyRequest.getState())
                //.registration_date(propertyRequest.getRegistration_date())
                //.registration_time(propertyRequest.getRegistration_time())
                .name(propertyRequest.getName())
                .description(propertyRequest.getDescription())
                .noted(propertyRequest.getNoted())
                .build();
    }
    @Override
    public PropertyResponse propertyToResponse(Property entity) {
        return PropertyResponse.builder()
                .id(entity.getId())
                .property_type(entity.getProperty_type())
                .address(entity.getAddress())
                .province(entity.getProvince())
                .city(entity.getCity())
                .price(entity.getPrice())
                .square_meter(entity.getSquare_meter())
                .bedrooms(entity.getBedrooms())
                .bathrooms(entity.getBathrooms())
                .contract_type(entity.getContract_type())
                .state(entity.getState())
                .user_registration(entity.getUser_registration())
                .property_image(entity.getProperty_image().stream()
                        .map(i -> imageMapper.imageToResponse(i))
                        .collect(Collectors.toList()))
                .registration_date(entity.getRegistration_date())
                .registration_time(entity.getRegistration_time())
                .name(entity.getName())
                .description(entity.getDescription())
                .noted(entity.getNoted())
                .build();
    }
    public Property updateProperty(Property property, PropertyRequest propertyRequest){
        property.setAddress(propertyRequest.getAddress());
        property.setPrice(propertyRequest.getPrice());
        property.setSquare_meter(propertyRequest.getSquare_meter());
        property.setBedrooms(propertyRequest.getBedrooms());
        property.setBathrooms(propertyRequest.getBathrooms());
        property.setContract_type(propertyRequest.getContract_type());
        //property.setState(propertyRequest.getState());
        //property.setRegistration_time(propertyRequest.getRegistration_time());
        //property.setRegistration_date(propertyRequest.getRegistration_date());
        property.setName(propertyRequest.getName());
        property.setDescription(propertyRequest.getDescription());
        property.setNoted(propertyRequest.getNoted());
        return property;
    }
}
