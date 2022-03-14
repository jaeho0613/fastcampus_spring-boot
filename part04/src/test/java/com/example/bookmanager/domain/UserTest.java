package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @since 2022-03-14
 */
class UserTest {
    @Test
    void Test() {
        User user = new User();
        user.setEmail("martin@factcom.com");
        user.setName("jaeho");

        System.out.println(">>> " + user);

    }
}