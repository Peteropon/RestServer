package com.petros.restserver.model;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Animal {


    private @Id @GeneratedValue
    Long id;
    private String name;
    private @Nullable String color;
    private @Nullable String family;


    public Animal(String name, String color, String family) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.family = family;
    }

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

}
