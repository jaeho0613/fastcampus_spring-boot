package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    // https://openapi.naver.com/v1/search/local.json
    // ?query=%EA%B0%88%EB%B9%84%EC%A7%91
    // &display=10
    // &start=1
    // &sort=random
    @GetMapping("/naver")
    public String naver() {

        String query = "갈비집";
        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "중국집")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "bNKzxVh5mQzwhZTo47q0")
                .header("X-Naver-Client-Secret", "WcCMmzJnP4")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();
    }

    @GetMapping("/hello")
    public User hello(User user) {

        return user;
    }

//    @PostMapping("/user/{userId}/name/{userName}")
//    public User post(@RequestBody User user, @PathVariable int userId, @PathVariable String userName) {
//        log.info("userId : {}, user Name : {}", userId, userName);
//        log.info("client req : {}", user);
//
//        return user;
//    }

    //    @PostMapping("/user/{userId}/name/{userName}")
//    public User post2(
//            @RequestBody User user,
//            @PathVariable int userId,
//            @PathVariable String userName,
//            @RequestHeader("x-authorization") String authorization,
//            @RequestHeader("custom-header") String customHeader) {
//        log.info("userId : {}, user Name : {}", userId, userName);
//        log.info("x-authorization : {}, custom-header : {}", authorization, customHeader);
//        log.info("client req : {}", user);
//
//        return user;
//    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post3(
//            HttpEntity<String> entity,
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customHeader) {

//        log.info("req : {}", entity);
        log.info("userId : {}, user Name : {}", userId, userName);
        log.info("x-authorization : {}, custom-header : {}", authorization, customHeader);
        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );

        response.setResBody(user.getResBody());

        return response;
    }
}
