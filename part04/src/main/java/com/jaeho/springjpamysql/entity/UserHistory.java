package com.jaeho.springjpamysql.entity;

import com.jaeho.springjpamysql.entity.listener.Auditable;
import com.jaeho.springjpamysql.entity.listener.MyEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;

//    @LastModifiedDate
//    private LocalDateTime updatedAt;

}
