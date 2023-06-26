package com.example.demo;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SquareService {

    private final ThirdPartyClient client;

    public ThirdPartyResponse squareRemote(ThirdPartyRequest request) {
        return client.square(request);
    }

    public ThirdPartyResponse squareLocal(ThirdPartyRequest request) {
        Integer square = request.getSquare();
        return ThirdPartyResponse.builder()
            .result(square * square)
            .build();
    }
}
