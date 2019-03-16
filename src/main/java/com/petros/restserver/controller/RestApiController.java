package com.petros.restserver.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.petros.restserver.model.Animal;
import com.petros.restserver.model.AnimalRepository;
import com.petros.restserver.model.AnimalResourceAssembler;
import com.petros.restserver.util.AnimalExistsException;
import com.petros.restserver.util.AnimalNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);}

    @GetMapping
    public String home() {
        return "This api provides a list of some animals we all like. Feel free to add an animal " +
                "that you like or delete one you don't like.";
    }

    @GetMapping(value = "/animals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resources getAll(){
        log.info("Request for all available animals.");
        List<Resource<Animal>> animals = animalRepository.findAll().stream().map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(animals, linkTo(methodOn(RestApiController.class).getAll()).withSelfRel());
    }

    @GetMapping(value = "/animals/{id}")
        public Resource<Animal> findById(@PathVariable Long id){
//            Animal animal = animalRepository.getOne(id);
//            if(animal == null) {
//                return new ResponseEntity(new AnimalNotFoundException("Not fount"), HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(animal, HttpStatus.OK);



            log.info("Request for animal with id " + id);
        Animal animal = animalRepository.getOne(id);
        if(animal != null) {
            return assembler.toResource(animalRepository.getOne(id));
        } else throw new AnimalNotFoundException("There is no animal with id: " + id);
    }

    @PostMapping(value = "/animals")
    public ResponseEntity<?> createAnimal(@RequestBody Animal animal) throws URISyntaxException{
        log.info("Creating new animal: ", animal.getName());
        if(animalRepository.existsById(animal.getId())){
            throw  new AnimalExistsException("This animal already exists in the database.");
        }
        Resource<Animal> resource = assembler.toResource(animalRepository.save(animal));
        return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
    }



}
