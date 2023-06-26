package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;

@ExtendWith(MockitoExtension.class)
class SquareServiceMockitoTest {

    @Mock
    private ThirdPartyClient client;

    @InjectMocks
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