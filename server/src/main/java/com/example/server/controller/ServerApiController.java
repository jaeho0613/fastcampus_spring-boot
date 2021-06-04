package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

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
