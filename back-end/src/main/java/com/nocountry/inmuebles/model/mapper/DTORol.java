package com.nocountry.inmuebles.model.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nocountry.inmuebles.model.entity.User;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.List;

@Builder
public record DTORol(
        @NotBlank Long id,
        @NotBlank String description,
        @NotBlank List<DTOUser> listUser
) {
}
