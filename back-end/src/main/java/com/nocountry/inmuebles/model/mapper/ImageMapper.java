package com.nocountry.inmuebles.model.mapper;

import com.nocountry.inmuebles.model.entity.Image;
import com.nocountry.inmuebles.model.response.ImageResponse;

public interface ImageMapper {
    //img ---> ImageResponse
    ImageResponse imageToResponse(Image img);
}