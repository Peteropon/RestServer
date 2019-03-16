package com.petros.restserver.service;

import com.petros.restserver.model.Animal;

import java.util.List;

public interface AnimalService {

    Animal findById(Long id);

    void saveAnimal(Animal animal);

    void updateAnimal(Animal animal);

    void deleteAnimalById(Long id);

    void deleteAllAnimals();

    Animal findByName(String name);

    List<Animal> findAllAnimals();

}
