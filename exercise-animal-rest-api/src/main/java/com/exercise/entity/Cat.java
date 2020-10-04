package com.exercise.entity;

import com.exercise.entity.Animal;
import com.exercise.model.AnimalTypes;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

    public Cat() {
        family = AnimalTypes.MAMMAL.toString();
    }

    public void move() {
        System.out.println("Cats can walk");
    }

}
