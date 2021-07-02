package com.example.Controller;

import com.example.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

    @PutMapping("/normal")
    public PutRequestDto put(@RequestBody PutRequestDto dto) {
        System.out.println(dto);
        return dto;
    }

    @PutMapping("/normal/{name}")
    public PutRequestDto put(@RequestBody PutRequestDto dto, @PathVariable String name) {
        System.out.println(dto);
        System.out.println(name);
        return dto;
    }
}
