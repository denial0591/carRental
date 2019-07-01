package com.novikov.carrental;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.novikov.carrental.repository")
@Slf4j
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }

}
