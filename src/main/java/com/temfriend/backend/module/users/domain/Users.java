package com.temfriend.backend.module.users.domain;

import com.temfriend.backend.global.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Users extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Profile profile;

    @Builder
    public Users(String email, String password, Role role, Profile profile) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.profile = profile;
    }
}
