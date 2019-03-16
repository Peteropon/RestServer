package com.petros.restserver.controller;


import com.petros.restserver.model.Animal;
import com.petros.restserver.model.AnimalRepository;
import com.petros.restserver.model.AnimalResourceAssembler;
import com.petros.restserver.util.AnimalNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Slf4j
public class RestApiController {

    private AnimalRepository animalRepository;
    private AnimalResourceAssembler assembler;

    public RestApiController(AnimalResourceAssembler assembler, AnimalRepository animalRepository) {
        this.assembler = assembler;
        this.animalRepository = animalRepository;
    }


    @GetMapping
    public String home() {
        return "This api provides a list of some animals we all like. Feel free to add an animal " +
                "that you like or delete one you don't like.";
    }

    @GetMapping("/animals")
    public Resources getAll(){
        log.info("Request for all available animals.");
        List<Resource<Animal>> animals = animalRepository.findAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(animals, linkTo(methodOn(RestApiController.class).getAll()).withSelfRel());
    }

    @GetMapping("/animals/{id}")
    public Resource<Animal> findById(@PathVariable Long id){
        log.info("Request for animal with id " + id);
        Animal animal = animalRepository.getOne(id);
        if(animal != null) {
            return assembler.toResource(animalRepository.getOne(id));
        } else throw
                new AnimalNotFoundException("No animal with this id." +
                        "\nPlease try again");

    }


}
