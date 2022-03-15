package com.jaeho.springjpamysql.entity.listener;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);
}
