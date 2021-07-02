package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class 는 Rest API 처리하는 Controller 등록
@RequestMapping("/api") // RequestMapping url 지정
public class ApiController {

    @GetMapping("/hello") // localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }
}
