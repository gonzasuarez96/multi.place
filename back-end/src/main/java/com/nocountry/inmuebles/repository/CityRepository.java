package com.nocountry.inmuebles.repository;

import com.nocountry.inmuebles.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
    List<City> findAllByProvinceIdOrderByDescriptionAsc(Long id);
}
