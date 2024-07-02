package com.nocountry.inmuebles.service.abstraction;

import com.nocountry.inmuebles.model.entity.Image;
import com.nocountry.inmuebles.model.entity.Property;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public interface AwsService {
    List<Image> uploadImage(List<MultipartFile> file, Property property) throws IOException;
}
