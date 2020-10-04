package com.exercise.dao;

import com.exercise.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

    List<Animal> findByType(String type);

    List<Animal> findByFamily(String family);

    List<Animal> findByTypeAndFamily(String type, String family);
}
