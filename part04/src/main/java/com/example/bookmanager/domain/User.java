package com.example.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @since 2022-03-14
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class User {
    @NonNull
    private String name;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
