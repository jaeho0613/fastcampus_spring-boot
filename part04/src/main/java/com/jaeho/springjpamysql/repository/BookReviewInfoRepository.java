package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
