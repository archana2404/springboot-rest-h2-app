package com.exercise.entity;

import com.exercise.model.AnimalTypes;

import javax.persistence.Entity;

@Entity
public class Snake extends Animal {

    public Snake() {
        this.family = String.valueOf(AnimalTypes.REPTILES);
    }

    public void move() {
        System.out.println("Snake can crawl");
    }
}
