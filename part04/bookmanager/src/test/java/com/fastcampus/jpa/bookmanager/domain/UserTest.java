package com.fastcampus.jpa.bookmanager.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("ywm2004@gmail.com");
        user.setName("jaeho");

        log.info("{}", user);

        User user1 = User.builder().name("aaa").email("adf").build();

        log.info("{}", user1);

    }
}