package com.jaeho.springjpamysql.entity;

import com.jaeho.springjpamysql.entity.listener.Auditable;
import com.jaeho.springjpamysql.entity.listener.MyEntityListener;
import com.jaeho.springjpamysql.entity.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@EntityListeners(value = UserEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NonNull
    private String name;

    @NonNull
    private String email;

//    @Column(name = "created_at", updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;

    //    @Column(name = "updated_at", insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void perPersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void PreUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}