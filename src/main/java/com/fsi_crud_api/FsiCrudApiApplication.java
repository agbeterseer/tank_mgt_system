package com.fsi_crud_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FsiCrudApiApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(FsiCrudApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FsiCrudApiApplication.class, args);
	}
        
 
}
