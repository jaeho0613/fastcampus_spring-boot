package com.example.springioc;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")
public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String url) {
        return Base64.getEncoder().encodeToString(url.getBytes());
    }
}
