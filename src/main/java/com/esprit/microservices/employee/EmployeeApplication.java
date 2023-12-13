package com.esprit.microservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Autowired
    private EmployeeRepository repository;

    @Bean
    ApplicationRunner init() {
      return (args) ->{
         /* repository.save(new Employee("amal","achour",25,"resppnsable de produit","12/02/2023",true));
          repository.save(new Employee("oumaima","debbich",40,"resppnsable de stocks","16/05/2023",false));
          repository.save(new Employee("asma","achour",30,"resppnsable de employé","12/02/2023",true));
*/
          repository.findAll().forEach(System.out::println);
      };
    }

}
