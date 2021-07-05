package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Set;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void crud() { // create , read, update, delete

        // ---------------------- read ---------------------------------
//        List<User> r_users1 = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); // sort option : 정렬
//        List<User> r_users2 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)); // multi find
//        r_users1.forEach(user -> log.info("{}", user));
//        r_users2.forEach(user -> log.info("{}", user));

//        User r_user1 = userRepository.getOne(1L); // getOne : 레이지 패치를 지원
//        Optional<User> r_user2 = userRepository.findById(1L); // findById : optional 반납
//        User r_user3 = userRepository.findById(1L).orElse(null); // orElse : 검사를 하여 데이터가 없으면 null 반환
//        log.info("{}", r_user3);

//        long count = userRepository.count(); // total count
//        log.info("{}", count);

//        boolean exists = userRepository.existsById(1L); // 해당 id가 있는지 확인하여 boolean 반환
//        log.info("{}", exists);

        // ---------------------- create ---------------------------------
//        User user1 = new User("jack", "test@naver.com");
//        User user2 = new User("sts", "test2@naver.com");

//        userRepository.saveAll(Lists.newArrayList(user1, user2));

//        List<User> users = userRepository.findAll();

//        users.forEach(user -> log.info("{}", user));

        // ----------------------- delete ------------------------------
        // 1. repository.delete : 해당 아이디, 데이터를 체크한 후 제거
        // 2. repository.deleteInBatch : 데이터 체크 없이 제거
        // 3. repository.deleteAllInBatch : 위와 동일

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)));
//        userRepository.findAll().forEach(System.out::println);

//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)));
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);

        // ---------------------- update -----------------------
        // 1. delete와 동일하게 1번 select 하여 데이터를 확인하고 업데이트한다.
        userRepository.save(new User("david", "david@fastcompus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("reDavid@fastcom.com");

        userRepository.save(user);
    }

    @Test
    void Page() {
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        log.info("page : {}", users);
        log.info("totalElements : {}", users.getTotalElements());
        log.info("totalPages : {}", users.getTotalPages());
        log.info("numberOfElements : {}", users.getNumberOfElements());
        log.info("sort : {}", users.getSort());
        log.info("size : {}", users.getSize());
        users.getContent().forEach(user -> {
            log.info("user : {}", user);
        });
    }

    @Test
    void Query() {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());

//        Example<User> example = Example.of(new User("ma", "test@naver.com"), matcher);
//        userRepository.findAll(example).forEach(user -> log.info("{}", user));

        User temp = new User();
        temp.setEmail("test");

        ExampleMatcher matcher2 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example2 = Example.of(temp, matcher2);
        userRepository.findAll(example2).forEach(System.out::println);
    }

    @Test
    void select() {
//        log.info("{}", userRepository.findByName("martin"));
//
//        log.info("{}", userRepository.findByEmail("test@naver.com"));
//        log.info("{}", userRepository.getByEmail("test@naver.com"));
//        log.info("{}", userRepository.readByEmail("test@naver.com"));
//        log.info("{}", userRepository.queryByEmail("test@naver.com"));
//        log.info("{}", userRepository.searchByEmail("test@naver.com"));
//        log.info("{}", userRepository.streamByEmail("test@naver.com"));
//        log.info("{}", userRepository.findUserByEmail("test@naver.com"));

//        log.info("{}", userRepository.findSomthingByEmail("test@naver.com"));

//        log.info("{}", userRepository.findTop2ByName("martin"));
//        log.info("{}", userRepository.findFirst2ByName("martin"));

//        log.info("{}", userRepository.findByEmailAndName("test@naver.com","martin"));
//        log.info("{}", userRepository.findByEmailOrName("test@naver.com","martin"));

//        log.info("{}", userRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L)));

//        log.info("{}", userRepository.findByIdAfter(4L));
//        log.info("{}", userRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        log.info("{}", userRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

//        log.info("{}", userRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        log.info("{}", userRepository.findByIdBetween(1L, 3L));
        log.info("{}", userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L,3L));

    }
}
