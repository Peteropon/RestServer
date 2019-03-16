package com.petros.restserver.model;


import com.petros.restserver.service.AnimalService;
import com.petros.restserver.util.AnimalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    public static final AtomicLong counter =  new AtomicLong();

    private static List<Animal> animals;


    @Override
    public Animal findById(Long id) {
        for (Animal animal:animals) {
            if(animal.getId()==id) return animal;
        }
        return null;
    }

    @Override
    public void saveAnimal(Animal animal) {
        animal.setId(counter.incrementAndGet());
        animals.add(animal);
    }

    @Override
    public void updateAnimal(Animal animal) {
        int index = animals.indexOf(animal);
        animals.set(index, animal);
    }

    @Override
    public void deleteAnimalById(Long id) {

    }

    @Override
    public void deleteAllAnimals() {

    }

    @Override
    public Animal findByName(String name) {
        return null;
    }

    @Override
    public List<Animal> findAllAnimals() {
        return null;
    }
}
