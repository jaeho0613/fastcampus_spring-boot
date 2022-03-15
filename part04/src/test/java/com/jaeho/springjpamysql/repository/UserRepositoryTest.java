package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.Gender;
import com.jaeho.springjpamysql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", contains());

        Example<User> example = Example.of(new User("ma", "naver.com"), matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("jaeho"));

//        System.out.println("findByEmail : " + userRepository.findByEmail("jaeho@naver.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("jaeho@naver.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("jaeho@naver.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("jaeho@naver.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("jaeho@naver.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("jaeho@naver.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("jaeho@naver.com"));
//
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("jaeho"));
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("jaeho"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("jaeho"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("jaeho@naver.com", "minsu"));

//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("jaeho@naver.com", "minsu"));

//        System.out.println("findByEmailOrName : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(1));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(6, 8));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(6, 8));

//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("jaeho", "minsu")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("jae"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("ae"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("ho"));
    }

    @Test
    void pagingAndSorting() {
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("jaeho"));
//        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("jaeho"));
//        System.out.println("findFirstByNameOrOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("jaeho"));

//        System.out.println("findFirstByNameSort : " + userRepository.findFirstByName("jaeho", getSort()));
        System.out.println("findByNamePaging : " + userRepository.findByName("jaeho", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.desc("email")
        );
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("jaeho");
        user.setEmail("jaeho@gogogo.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1).orElseThrow(RuntimeException::new);
        user2.setName("testsssssssssssssss");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);


        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setName("test");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("test@test.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("tetsssssssssssssssssss");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("test@naver.com");
        user.setName("test");

        userRepository.save(user);

        user.setName("test-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

    }
}