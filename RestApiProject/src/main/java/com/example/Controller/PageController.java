package com.example.Controller;

import com.example.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("steve");
        user.setAddress("공항대로");

        return user;
    }
}
