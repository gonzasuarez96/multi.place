package com.nocountry.inmuebles.model.mapper;

import com.nocountry.inmuebles.model.entity.Image;
import com.nocountry.inmuebles.model.response.ImageResponse;
import org.springframework.stereotype.Component;

@Component
public class ImageMapperImpl implements ImageMapper{
    @Override
    public ImageResponse imageToResponse(Image img) {
        return ImageResponse.builder()
                .id(img.getId())
                .route(img.getRoute())
                .build();
    }
}
