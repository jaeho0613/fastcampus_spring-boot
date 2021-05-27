package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;

    // json과 변수명이 다를 경우 맵핑해주기 위한 어노테이션
    @JsonProperty("phone_number")
    private String phoneNumber; // phone_number

    @JsonProperty("OTP")
    private String OTP;

}
