package com.exercise.entity;

import com.exercise.model.AnimalTypes;

import javax.persistence.Entity;

@Entity
public class Shark extends Animal {

    public Shark() {
        this.family = String.valueOf(AnimalTypes.FISH);
    }

    public void move() {
        System.out.println("Shark can swim");
    }
}
