package com.example.onefit.liked;

import com.example.onefit.liked.dto.LikedCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LikedContollerTest {

    private final ObjectMapper objectMapper=new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    void create()
    {}
//
//    @Test
//    void create() throws Exception {
//        //given / LikedCreateDto berilgan
//        LikedCreateDto likedCreateDto = new LikedCreateDto();
//        likedCreateDto.setUser_id(UUID.fromString("5318ba6e-836e-422f-b5ff-1cd8d4e2a867"));
//        likedCreateDto.setCourse_id(UUID.fromString("67dd619d-fb26-47f2-a580-e328b3f114cf"));
//
//        RequestBuilder postRequest =MockMvcRequestBuilders
//              .post("/liked")
//                .contentType("application/json")
//
//
//                .content(objectMapper.writeValueAsString(likedCreateDto));
//
//        //when | Controllerga post request yuborish
//
//        ResultActions response = mockMvc.perform(postRequest);
//
//        //then | 1. Response status code 201
//        // | databasega saqlangan yoki yo'qligini test qilishim kerak
//        // |fieldlar mosligini test qilaman
//
//        response.
//                andExpect(status().isCreated());
//    }

    @Test
    void getId() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}