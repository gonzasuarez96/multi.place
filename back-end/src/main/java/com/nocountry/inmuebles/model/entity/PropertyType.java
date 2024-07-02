package com.nocountry.inmuebles.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "property_type")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany(mappedBy = "property_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    private List<Property> properties;
}
