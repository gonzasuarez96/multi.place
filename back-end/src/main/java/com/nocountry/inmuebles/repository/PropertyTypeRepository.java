package com.nocountry.inmuebles.repository;

import com.nocountry.inmuebles.model.entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long>, JpaSpecificationExecutor<PropertyType> {
}
