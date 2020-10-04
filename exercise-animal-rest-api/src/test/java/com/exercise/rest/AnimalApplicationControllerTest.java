package com.exercise.rest;

import com.exercise.dao.AnimalRepository;
import com.exercise.entity.Animal;
import com.exercise.entity.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnimalApplicationController.class)
public class AnimalApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private AnimalRepository animalRepository;

    @Test
    public void givenAnimal_whenGetAnimal_thenReturnJsonArray()
            throws Exception {

        Animal cat = new Cat();
        cat.setName("Lucy");
        cat.setType("Cat");
        cat.setId(Long.valueOf(1));

        List<Animal> catList = new ArrayList<Animal>();
        catList.add(cat);

        given(animalRepository.findByType("Cat")).willReturn(catList);

        mockMvc.perform(get("/animal/search/?type=Cat")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void givenAnimal_whenRetriveAnimal_thenReturnJson()
            throws Exception {

        Animal cat = new Cat();
        cat.setName("Lucy");
        cat.setType("Cat");
        cat.setId(Long.valueOf(1));

        given(animalRepository.save(Mockito.any())).willReturn(cat);
        mockMvc.perform(post("/animal/").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(cat))).andExpect(status().isCreated());
        verify(animalRepository, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(animalRepository);


    }
}
