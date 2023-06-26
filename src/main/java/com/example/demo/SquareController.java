package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SquareController {

    private final SquareService squareService;

    @PostMapping("/square")
    public ThirdPartyResponse square(@RequestBody ThirdPartyRequest request) {
        return squareService.squareRemote(request);
    }
}
