package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class CarDto {

    private String name;

    @JsonProperty("car_number")
    private String carNumber;
}
