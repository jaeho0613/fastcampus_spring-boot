package com.company.design;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // ioc 적용 전
        // Base 64 encoding
//        IEncoder encoder = new Base64Encoder();
//        String result = encoder.encode(url);
//        System.out.println(result);

        // Url Encoder
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);
//        System.out.println(urlResult);

        // ioc 적용 후
        Encoder encoders = new Encoder(new Base64Encoder());
        String iocEncoder = encoders.encode(url);
        System.out.println(iocEncoder);

        encoders.setEncoder(new UrlEncoder());
        String iocUrlEncoder = encoders.encode(url);
        System.out.println(iocUrlEncoder);


    }
}
