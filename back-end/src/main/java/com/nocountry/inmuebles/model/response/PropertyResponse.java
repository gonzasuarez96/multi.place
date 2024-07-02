package com.nocountry.inmuebles.model.response;

import com.nocountry.inmuebles.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PropertyResponse implements Serializable {
    private final Long id;
    private final PropertyType property_type;
    private final Address address;
    private final Province province;
    private final City city;
    private final Double price;
    private final Integer square_meter;
    private final Integer bedrooms;
    private final Integer bathrooms;
    private final String contract_type;
    private final Boolean state;
    private final User user_registration;
    private final List<ImageResponse> property_image;
    private final String registration_date;
    private final String registration_time;
    private final String name;
    private final String description;
    private final Boolean noted;
}
