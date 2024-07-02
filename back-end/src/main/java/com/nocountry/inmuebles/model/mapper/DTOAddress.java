package com.nocountry.inmuebles.model.mapper;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record DTOAddress(
        @NotBlank String street,
        @NotBlank String number,
        @NotBlank String complement,
        @NotBlank String locationLat,
        @NotBlank String locationLen) {

}
