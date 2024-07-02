package com.nocountry.inmuebles.controller;

import com.nocountry.inmuebles.InmueblesApplication;
import com.nocountry.inmuebles.model.request.PropertyRequest;
import com.nocountry.inmuebles.model.response.PropertyResponse;
import com.nocountry.inmuebles.service.abstraction.AwsService;
import com.nocountry.inmuebles.service.abstraction.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/property")
public class PropertyController {
    private static final Logger logger = LoggerFactory.getLogger(InmueblesApplication.class);
    private final PropertyService propertyService;
    private final AwsService awsService;

    //-------------------------------------------- Register Property Method --------------------------------------------
    @PostMapping("/add")
    public PropertyResponse registerProperty(@RequestPart(value = "img", required = false)List<MultipartFile> img,
                                             @RequestPart(value = "propertyRequest") PropertyRequest propertyRequest) {
        return propertyService.createProperty(img, propertyRequest);
    }
    @GetMapping("/all")
    public List<PropertyResponse> getAll(){
        return propertyService.getAll();
    }
    @GetMapping("/findById/{id}")
    public PropertyResponse getById(@PathVariable("id") Long id){
        return propertyService.getById(id);
    }
    @PutMapping("/update/{id}")
    public void updateProperty(@PathVariable("id") Long id,@RequestBody PropertyRequest propertyRequest) throws Exception {
        propertyService.update(id, propertyRequest);
    }
    @DeleteMapping("{id}")
    public void deleteProperty(@PathVariable("id") Long id){
        propertyService.delete(id);
    }
    //-------------------------------------------- FindAll with Filters ----------------------------------------------//
    @GetMapping("/filter")
    public ResponseEntity<Page<PropertyResponse>> findAll(@RequestParam(required = false) Boolean noted,
                                                  @RequestParam(required = false) String province,
                                                  @RequestParam(required = false) String city,
                                                  @RequestParam(required = false) String type,
                                                  @RequestParam(required = false) Double minimumPrice,
                                                  @RequestParam(required = false) Double maximumPrice,
                                                  @RequestParam(required = false) Integer bedrooms,
                                                  @RequestParam(required = false) Integer bathrooms,
                                                  @RequestParam(required = false) Integer minimumSquareMeter,
                                                  @RequestParam(required = false) Integer maximumSquareMeter,
                                                  @RequestParam(required = false) Boolean state,
                                                  @RequestParam(required = false) String contractType,
                                                  Pageable pageable){
        return ResponseEntity.ok(propertyService.findAll(province,city,noted,type,minimumPrice,maximumPrice,bedrooms,bathrooms
                ,minimumSquareMeter,maximumSquareMeter,state,contractType,pageable));
    }
}
