package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
