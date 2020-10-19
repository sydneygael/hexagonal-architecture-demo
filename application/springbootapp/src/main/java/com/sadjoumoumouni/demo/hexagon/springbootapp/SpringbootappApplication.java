package com.sadjoumoumouni.demo.hexagon.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sadjoumoumouni.demo.hexagon.adapters.product.drivens")
@EntityScan(basePackages = "com.sadjoumoumouni.demo.hexagon.domain")
public class SpringbootappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootappApplication.class, args);
    }

}
