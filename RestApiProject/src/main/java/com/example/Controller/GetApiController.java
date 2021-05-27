package com.example.Controller;

import com.example.dto.GetRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping("/mapping_hello")
    public String hello() {
        return "getMapping";
    }

    @RequestMapping(path = "/request_hello")
    public String hello2() {
        return "request Hellow";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        return "name : " + name;
    }

    @GetMapping("/path-variable2/{name}")
    public String pathVariable2(@PathVariable(name = "name") String pathName) {
        return "name : " + pathName;
    }

    // http://localhost:8080/api/get/query-param?name=steve&email=stev@gmail.com&age=30
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/get/query-param2?name=steve&email=stev@gmail.com&age=30
    @GetMapping("/query-param2")
    public String queryParam2(GetRequestDto user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getEmail());

        return user.toString();
    }

    // http://localhost:8080/api/get/query-param3?name=steve&email=stev@gmail.com&age=30
    @GetMapping("/query-param3")
    public String queryParam3(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }
}
