package com.company.design;

import java.util.Base64;

public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String url) {
        return Base64.getEncoder().encodeToString(url.getBytes());
    }
}
