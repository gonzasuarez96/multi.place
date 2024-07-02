package com.nocountry.inmuebles;

import lombok.extern.apachecommons.CommonsLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InmueblesApplication{
	private static final Logger logger = LoggerFactory.getLogger(InmueblesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InmueblesApplication.class, args);
		logger.info("========================");
		logger.info("c14-27-m-java-react");
		logger.info("========================");
	}

}
