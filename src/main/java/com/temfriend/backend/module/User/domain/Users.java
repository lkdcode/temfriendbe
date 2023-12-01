package com.temfriend.backend.module.User.domain;

import com.temfriend.backend.global.domain.BaseEntity;
import com.temfriend.backend.module.User.domain.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Users extends BaseEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Profile profile;
}
