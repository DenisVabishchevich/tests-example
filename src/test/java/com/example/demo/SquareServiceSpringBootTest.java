package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    SquareService.class
})
class SquareServiceSpringBootTest {

    @MockBean
    private ThirdPartyClient client;

    @Autowired
    private SquareService squareService;

    @Test
    void squareMockitoTest() {

        Mockito.when(client.square(Mockito.argThat(r -> r.getSquare().equals(4))))
            .thenReturn(ThirdPartyResponse.builder()
                .result(15)
                .build());

        ThirdPartyResponse thirdPartyResponse = squareService.squareRemote(ThirdPartyRequest.builder()
            .square(4)
            .build());

        Assertions.assertThat(thirdPartyResponse).isNotNull();
        Assertions.assertThat(thirdPartyResponse.getResult()).isEqualTo(15);
    }
}