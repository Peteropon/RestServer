package com.petros.restserver.model;

import com.petros.restserver.controller.RestApiController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AnimalResourceAssembler implements ResourceAssembler<Animal, Resource<Animal>> {

    @Override
    public Resource<Animal> toResource(Animal animal) {
        return new Resource<>(animal, linkTo(methodOn(RestApiController.class).findById(animal.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).getAll()).withRel("animals"));
    }

}
