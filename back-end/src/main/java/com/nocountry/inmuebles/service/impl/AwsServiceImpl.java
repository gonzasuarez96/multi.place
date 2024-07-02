package com.nocountry.inmuebles.service.impl;

import com.nocountry.inmuebles.model.entity.Image;
import com.nocountry.inmuebles.model.entity.Property;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import com.nocountry.inmuebles.service.abstraction.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AwsServiceImpl implements AwsService {
    @Autowired
    private S3Client awsConfig;
    @Value("${aws.bucketName}")
    private String bucketName;
    @Override
    public List<Image> uploadImage(List<MultipartFile> file, Property property) throws IOException {
        try{
            List<Image> list = new ArrayList<>();
            for (MultipartFile files : file){
                String fileName = files.getOriginalFilename();
                PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(fileName)
                        .build();
                awsConfig.putObject(putObjectRequest, RequestBody.fromBytes(files.getBytes()));
                String imageUrl = awsConfig.utilities().getUrl(GetUrlRequest.builder().bucket(bucketName).key(fileName).build()).toExternalForm();
                Image image = new Image();
                image.setRoute(imageUrl);
                image.setProperty(property);
                list.add(image);
            }
            return list;
        }catch (SdkClientException e){
            throw new RuntimeException("Error: No se cargo el archivo en aws"+ e.getMessage());
        }
    }

    /*@Override
    public List<Image> uploadFile(List<MultipartFile> file) throws IOException {
        try {
            List<Image> list = new ArrayList<>();
            for (MultipartFile files: file
                 ) {
                String filename = files.getOriginalFilename();
                PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(filename)
                        .build();
                s3Client.putObject(putObjectRequest, RequestBody.fromBytes(files.getBytes()));
                String imageUrl = s3Client.utilities().getUrl(GetUrlRequest.builder().bucket(bucket).key(filename).build()).toExternalForm();
                Image image = new Image();
                image.setImageUrl(imageUrl);
                list.add(image);
            }
            return list;
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }*/
}
