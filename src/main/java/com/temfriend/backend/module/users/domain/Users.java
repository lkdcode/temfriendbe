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
    public Users(String email, String password, String role, String name, String nickname, String img) {
        this.email = email;
        this.password = password;
        this.role = Role.from(role);
        this.profile = Profile.builder()
                .name(name)
                .nickname(nickname)
                .img(img)
                .build();
    }

    public void promoteGrade() {
        this.profile.promoteGrade();
    }
}
