package com.nocountry.inmuebles.model.mapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DTOImage(
        @NotBlank Long id,
        @NotBlank String route,
        @NotBlank DTORegisterProperty property) {
}
