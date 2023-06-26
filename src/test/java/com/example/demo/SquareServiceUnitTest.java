package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;

// Unit test
class SquareServiceUnitTest {

    private final SquareService squareService = new SquareService(new ThirdPartyClient(new RestTemplate()));

    @Test
    void squareLocalTest() {
        ThirdPartyResponse thirdPartyResponse = squareService.squareLocal(ThirdPartyRequest.builder()
            .square(4)
            .build());

        Assertions.assertThat(thirdPartyResponse).isNotNull();
        Assertions.assertThat(thirdPartyResponse.getResult()).isEqualTo(16);
    }
}