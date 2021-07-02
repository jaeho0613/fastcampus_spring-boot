package com.example.aync.controller;

import com.example.aync.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public CompletableFuture hello() {
        log.info("completable future init");
        return asyncService.run();
    }
}
