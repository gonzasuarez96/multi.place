package com.nocountry.inmuebles.repository;

import com.nocountry.inmuebles.model.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {
    void deleteById(Long id);
}
