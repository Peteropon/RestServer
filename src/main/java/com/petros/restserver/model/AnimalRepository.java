package com.petros.restserver.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
