package com.petros.restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.petros")
public class RestserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestserverApplication.class, args);
    }

}
