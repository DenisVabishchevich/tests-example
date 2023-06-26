package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ThirdPartyRequest;
import com.example.demo.dto.ThirdPartyResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThirdPartyClient {

    private final RestTemplate restTemplate;

    public ThirdPartyResponse square(ThirdPartyRequest request) {
        return restTemplate.exchange("http://localhost:4444/client/square", HttpMethod.POST, new HttpEntity<>(request), ThirdPartyResponse.class)
            .getBody();
    }
}
