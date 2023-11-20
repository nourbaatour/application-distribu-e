package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
@EnableEurekaClient
public class SupplierrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierrApplication.class, args);
	}
@Autowired
private SupplierRepository repository;
@Bean
ApplicationRunner init() {
    return args -> {
        try {
            repository.save(new Supplier("GoSport", "Paris", "gosport@gmail.com"));
            repository.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}
}
