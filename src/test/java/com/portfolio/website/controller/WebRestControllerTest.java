package com.portfolio.website.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebRestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지(){
        //given

        //when
        String body = restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("Spring boot web service");
    }

    @Test
    public void Profile확인() {

        //given

        //when
        String profile = restTemplate.getForObject("/profile", String.class);

        //then
        assertThat(profile).isEqualTo("local");

    }
}