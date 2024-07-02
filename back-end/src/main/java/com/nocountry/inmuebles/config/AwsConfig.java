package com.nocountry.inmuebles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

@Configuration
public class AwsConfig {
    @Value("${aws.accessKey}")
    private String accessKey;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.bucketName}")
    private String bucketName;
    @Value("${aws.bucketRegion}")
    private String regionName;

    @Bean
    public S3Client s3Client(){
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey,secretKey);
        return S3Client.builder()
                .region(Region.of(regionName))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
