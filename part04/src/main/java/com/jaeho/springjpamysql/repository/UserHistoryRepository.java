package com.jaeho.springjpamysql.repository;

import com.jaeho.springjpamysql.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
