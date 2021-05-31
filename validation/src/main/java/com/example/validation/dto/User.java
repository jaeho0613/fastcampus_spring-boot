package com.example.validation.dto;

import com.example.validation.anntation.YearMonth;
import lombok.Data;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

//    @Email
//    private String email;
//
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
//    private String phoneNumber;
//
//    @YearMonth
//    private String reqYearMonth; // yyyyMMdd

    @Valid
    private List<Car> cars;
}