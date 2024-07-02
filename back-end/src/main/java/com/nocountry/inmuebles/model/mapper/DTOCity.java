package com.nocountry.inmuebles.model.mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record DTOCity(
        @NotBlank Long id,
        @NotBlank String description,
        @NotBlank DTOProvince province,
        @NotBlank List<DTORegisterProperty> properties) {
}
