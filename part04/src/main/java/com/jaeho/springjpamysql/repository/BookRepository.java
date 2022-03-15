package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
