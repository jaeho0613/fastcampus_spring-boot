package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor, Long> {
}
