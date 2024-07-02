package com.nocountry.inmuebles.repository;

import com.nocountry.inmuebles.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long>, JpaSpecificationExecutor<Province> {
    List<Province> findAllByOrderByDescriptionAsc();
}
