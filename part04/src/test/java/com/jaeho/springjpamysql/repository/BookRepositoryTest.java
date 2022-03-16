package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.Book;
import com.jaeho.springjpamysql.entity.Publisher;
import com.jaeho.springjpamysql.entity.Review;
import com.jaeho.springjpamysql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격자 패키지");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    public void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("jaeho@naver.com");

        System.out.println("Review : " + user.getReview());
        System.out.println("Book : " + user.getReview().get(0).getBook());
        System.out.println("Publisher : " + user.getReview().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private User givenUser() {
        return userRepository.findByEmail("jaeho@naver.com");
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");

        return publisherRepository.save(publisher);
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("재밌다");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
}