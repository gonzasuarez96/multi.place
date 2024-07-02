package com.nocountry.inmuebles.util;


import com.nocountry.inmuebles.model.entity.Property;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PropertySpecification implements Specification<Property> {

    private Boolean noted;
    private String province;
    private String city;
    private String type;
    private Double minimumPrice;
    private Double maximumPrice;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer minimumSquareMeter;
    private Integer maximumSquareMeter;
    private Boolean state;
    private String contractType;
    @Override
    public Predicate toPredicate(Root<Property> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> lista = new ArrayList<>();
        final String d="description";
        if(noted!=null){
            lista.add(cb.equal(root.get("noted"),noted));
        }
        if(province!=null){
            lista.add(cb.equal(root.get("province").get(d),province));
        }
        if(city!=null){
            lista.add(cb.equal(root.get("city").get(d),city));
        }
        if(type!=null){
            lista.add(cb.equal(root.get("property_type").get(d),type));
        }
        if(minimumPrice!=null){
            lista.add(cb.greaterThanOrEqualTo(root.get("price"),minimumPrice));
        }
        if(maximumPrice!=null){
            lista.add(cb.lessThanOrEqualTo(root.get("price"),maximumPrice));
        }
        if(bedrooms!=null){
            lista.add(cb.greaterThanOrEqualTo(root.get("bedrooms"),bedrooms));
        }
        if(bathrooms!=null){
            lista.add(cb.greaterThanOrEqualTo(root.get("bathrooms"),bathrooms));
        }
        if(minimumSquareMeter!=null){
            lista.add(cb.greaterThanOrEqualTo(root.get("square_meter"),minimumSquareMeter));
        }
        if(maximumSquareMeter!=null){
            lista.add(cb.lessThanOrEqualTo(root.get("square_meter"),maximumSquareMeter));
        }
        if(state!=null){
            lista.add(cb.equal(root.get("state"),state));
        }
        if(contractType!=null){
            lista.add(cb.equal(root.get("contract_type"),contractType));
        }
        return cb.and(lista.toArray(new Predicate[lista.size()]));
    }
}
