package com.nocountry.inmuebles.model.mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record DTOProvince(
        @NotBlank Long id,
        @NotBlank String description,
        @NotBlank List<DTOCity> cities,
        @NotBlank List<DTORegisterProperty> properties) {
}
