package com.petros.restserver.util;

import com.petros.restserver.model.Animal;
import com.petros.restserver.model.AnimalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(AnimalRepository animalRepository){
        return args -> {
            log.info("Preloading " + animalRepository.save(new Animal("Fox", "Orange", "Canidae")));
            log.info("Preloading " + animalRepository.save(new Animal("Bear", "Brown", "Ursidae")));
            log.info("Preloading " + animalRepository.save(new Animal("Mongoose", "Brown", "Herpestidae")));
            log.info("Preloading " + animalRepository.save(new Animal( "Meerkat", "Yellow", "Herpestidae")));
            log.info("Preloading " + animalRepository.save(new Animal("Lion", "Yellow", "Felidae")));
        };
    }

}
