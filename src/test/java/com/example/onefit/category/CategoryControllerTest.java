/*
package com.example.onefit.category;

import com.example.onefit.category.dto.CategoryCreateDto;
import com.example.onefit.category.entity.Category;
import com.example.onefit.course.dto.CourseCreateDto;
import com.example.onefit.location.dto.LocationCreateDto;
import com.example.onefit.location.dto.LocationUpdateDto;
import com.example.onefit.location.entity.Location;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void create() throws Exception {

        LocationCreateDto createDto = new LocationCreateDto();

        createDto.setLatitude("Qwert");
        createDto.setLongitude("Qwert");
        createDto.setName("Qwerty");


        CourseCreateDto courseCreateDto = new CourseCreateDto();

        courseCreateDto.setDescription("This is the best course");
        courseCreateDto.setFemale(false);
        courseCreateDto.setName("Course 1");
        courseCreateDto.setImages(new ArrayList<>(List.of("qwrefg" , "Ewrqthg")));
        courseCreateDto.setLocation(createDto);


        String requestJson = objectMapper.writeValueAsString(courseCreateDto);



*/
/*
        ResultActions result =  mockMvc.perform(post("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id" , is(notNullValue())))
                .andExpect(jsonPath("$.name" , "Course 1"))
                .andExpect(jsonPath("$.images" , "Course 1"))
                .andExpect(jsonPath("$.description" , "Course 1"))
                .andExpect(jsonPath("$.female" , "Course 1"))
                .andExpect(jsonPath("$." , "Course 1")) ;*//*

    }

    @Test
    void get() {
    }

    @Test
    void testGet() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}*/
