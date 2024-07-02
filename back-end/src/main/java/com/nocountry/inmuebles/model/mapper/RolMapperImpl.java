package com.nocountry.inmuebles.model.mapper;

import com.nocountry.inmuebles.model.entity.Rol;

import java.util.stream.Collectors;

public class RolMapperImpl implements RolMapper{


    PropertyMapperImpl propertyMapper = new PropertyMapperImpl();
    @Override
    public Rol toEntityRol(DTORol dtoRol) {
        return Rol.builder()
                .id(dtoRol.id())
                .description(dtoRol.description())
                .listUser(dtoRol.listUser().stream()
                        .map(p->propertyMapper.toEntityUser(p))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public DTORol toDTORol(Rol rol) {
        return DTORol.builder()
                .id(rol.getId())
                .description(rol.getDescription())
                .listUser(rol.getListUser().stream()
                        .map(user -> propertyMapper.toDtoUser(user))
                        .collect(Collectors.toList()))
                .build();
    }
}
