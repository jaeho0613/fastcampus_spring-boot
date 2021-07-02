package com.example.client.controller;

import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/get")
    public UserResponse getHello() {
        return restTemplateService.get();
    }

    @PostMapping("/post")
    public UserResponse postHello() {
        restTemplateService.post();
        return new UserResponse();
    }

    @PostMapping("/post2")
    public UserResponse postExchange() {
        restTemplateService.exchange();
        return new UserResponse();
    }


    @PostMapping("/post3")
    public Req<UserResponse> genericExchange() {
        return restTemplateService.genericExchange();
    }
}
