package com.exercise.rest;

import com.exercise.dao.AnimalRepository;
import com.exercise.entity.Animal;
import com.exercise.model.AnimalDTO;
import com.exercise.model.AnimalFactory;
import org.mockito.Mock;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AnimalApplicationController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animal/{id}")
    public AnimalDTO retrieveAnimal(@PathVariable long id) {

        Optional<Animal> animal = animalRepository.findById(id);
        AnimalDTO animalDTO = new AnimalDTO();
        modelMapper.map(animal.get(), animalDTO);

        return animalDTO;
    }


    @GetMapping("/animal/search/")
    public List<AnimalDTO> searchAnimal
            (@RequestParam Optional<String> type, @RequestParam Optional<String> family) {

        System.out.println(type.orElse("Dog") + family.orElse("Mammal"));
        List<Animal> animal = null;
        if(type.isPresent() && family.isPresent()) {
            animal = animalRepository.findByTypeAndFamily(type.get(), family.get());
        } else if (family.isPresent()) {
            animal = animalRepository.findByFamily(family.get());
        } else {
            animal = animalRepository.findByType(type.get());
        }

        List<AnimalDTO> animalDTOList = mapList(animal, AnimalDTO.class);

        return animalDTOList;
    }

    @PostMapping("/animal")
    public ResponseEntity<Void> addAnimal(@RequestBody AnimalDTO animalDTO) {

        //Creating Object using Factory method
        Animal animal = AnimalFactory.getAnimalObject(animalDTO.getType());
        modelMapper.map(animalDTO, animal);
        animal = animalRepository.save(animal);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(animal.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
