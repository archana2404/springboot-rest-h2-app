package com.exercise.entity;

import com.exercise.entity.Animal;
import com.exercise.model.AnimalTypes;

import javax.persistence.Entity;

@Entity
public class Frog extends Animal {

    public Frog() {
        this.family = String.valueOf(AnimalTypes.AMPHIBIANS);
    }

    public void move() {
        System.out.println("Frogs can jump");
    }
}
