package com.example.aop.controller;

import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {

//        System.out.println("rest get : " + id);
//        System.out.println("rest get : " + name);

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
//        System.out.println(user.toString());
        return user;
    }
}
