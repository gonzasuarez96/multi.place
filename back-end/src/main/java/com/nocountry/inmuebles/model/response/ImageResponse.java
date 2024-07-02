package com.nocountry.inmuebles.model.response;

import com.nocountry.inmuebles.model.entity.Property;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ImageResponse {
    private Long id;
    private String route;
}
