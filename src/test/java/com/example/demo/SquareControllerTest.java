package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;

@WebMvcTest
class SquareControllerTest {

    @MockBean
    private SquareService squareService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void squareWebTest() {
        Mockito.when(squareService.squareRemote(Mockito.argThat(r -> r.getSquare().equals(4))))
            .thenReturn(ThirdPartyResponse.builder()
                .result(4)
                .build());

        webTestClient.post()
            .uri("/square")
            .bodyValue(ThirdPartyRequest.builder()
                .square(2)
                .build())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.result").value(Matchers.is(4));
    }

}