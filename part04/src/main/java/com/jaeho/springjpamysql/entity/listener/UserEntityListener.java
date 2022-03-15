package com.jaeho.springjpamysql.entity.listener;

import com.jaeho.springjpamysql.entity.User;
import com.jaeho.springjpamysql.entity.UserHistory;
import com.jaeho.springjpamysql.repository.UserHistoryRepository;
import com.jaeho.springjpamysql.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
