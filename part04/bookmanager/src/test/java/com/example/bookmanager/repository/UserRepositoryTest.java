package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud() { // create , read, update, delete

        // ---------------------- read ---------------------------------
        List<User> r_users1 = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        List<User> r_users2 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//        r_users1.forEach(user -> log.info("{}", user));
//        r_users2.forEach(user -> log.info("{}", user));

        User r_user1 = userRepository.getOne(1L); // getOne : 레이지 패치를 지원
        Optional<User> r_user2 = userRepository.findById(1L); // findById : optional 반납
        User r_user3 = userRepository.findById(1L).orElse(null);
        log.info("{}", r_user3);

        // ---------------------- create ---------------------------------
        User user1 = new User("jack", "test@naver.com");
        User user2 = new User("sts", "test2@naver.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

//        users.forEach(user -> log.info("{}", user));


    }
}