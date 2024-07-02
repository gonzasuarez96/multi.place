package com.nocountry.inmuebles.model.request;

import com.nocountry.inmuebles.model.entity.Address;
import com.nocountry.inmuebles.model.entity.Image;
import com.nocountry.inmuebles.model.entity.PropertyType;
import com.nocountry.inmuebles.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PropertyRequest {
    @NotNull private Long property_type_id;
    @NotNull private Address address;
    @NotNull private Long province_id;
    @NotNull private Long city_id;
    @NotNull private Double price;
    @NotNull private Integer square_meter;
    @NotNull private Integer bedrooms;
    @NotNull private Integer bathrooms;
    @NotBlank private String contract_type;
    @NotNull private Long user_id;
    @NotBlank private String name;
    private String description;
    @NotNull private Boolean noted;
}
