//package com.petros.restserver.model;
//
//
//import com.petros.restserver.service.AnimalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Service("animalService")
//public class AnimalServiceImpl implements AnimalService {
//
//    @Autowired
//    private AnimalRepository animalRepository;
//
//    public static final AtomicLong counter =  new AtomicLong();
//
//    private static List<Animal> animals;
//
//    static {
//        animals = populateAnimals();
//    }
//
//
//    @Override
//    public Optional<Animal> findById(Long id) {
//
//        return animalRepository.findById(id);
//    }
//
//    @Override
//    public void saveAnimal(Animal animal) {
//        animal.setId(counter.incrementAndGet());
//        animals.add(animal);
//    }
//
//    @Override
//    public void updateAnimal(Animal animal) {
//        int index = animals.indexOf(animal);
//        animals.set(index, animal);
//    }
//
//    @Override
//    public void deleteAnimalById(Long id) {
//        animals.removeIf(animal -> animal.getId() == id);
//    }
//
//    @Override
//    public void deleteAllAnimals() {
//        animals.clear();
//    }
//
//    @Override
//    public Animal findByName(String name) {
//        for (Animal animal: animals  ) {
//            if(animal.getName().equalsIgnoreCase(name))
//            return animal;
//        }
//        return null;
//    }
//
//    @Override
//    public List<Animal> findAllAnimals() {
//        return null;
//    }
//
//    private static List<Animal> populateAnimals() {
//        CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
//        animals.add(new Animal(counter.incrementAndGet(), "Fox", "Orange", "Canidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Bear", "Brown", "Ursidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Mongoose", "Brown", "Herpestidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Meerkat", "Yellow", "Herpestidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Lion", "Yellow", "Felidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Raccoon", "Grey", "Procyonidae"));
//        animals.add(new Animal(counter.incrementAndGet(), "Panther", "Black", "Felidae"));
//        return animals;
//    }
//
//}
