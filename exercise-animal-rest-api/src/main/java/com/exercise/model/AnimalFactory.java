package com.exercise.model;

import com.exercise.entity.*;
import org.springframework.util.StringUtils;

public class AnimalFactory {

    //Factory Pattern to create Animal Object
    public static Animal getAnimalObject(String type) {

        Animal animal = null;
        if (StringUtils.isEmpty(type)) {
            animal = new Animal();
            animal.setFamily(AnimalTypes.UNKNOWN.toString());
        } else if ("Dog".equalsIgnoreCase(type)) {
            animal = new Dog();
            return animal;
        } else if ("Cat".equalsIgnoreCase(type)) {
            animal = new Cat();
            return animal;
        } else if ("Frog".equalsIgnoreCase(type)) {
            animal = new Frog();
        } else if ("Snake".equalsIgnoreCase(type)) {
            animal = new Snake();
        } else if ("Shark".equalsIgnoreCase(type)) {
            animal = new Shark();
        }
        return animal;
    }
}
