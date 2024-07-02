package com.nocountry.inmuebles.model.mapper;

import com.nocountry.inmuebles.model.entity.Rol;

public interface RolMapper {
    Rol toEntityRol(DTORol dtoRol);
    DTORol toDTORol(Rol rol);
}
