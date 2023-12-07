package com.temfriend.backend.module.users.domain;

import com.temfriend.backend.global.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.enums.Authority;
import com.temfriend.backend.module.users.domain.enums.Grade;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Grade grade;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Embedded
    private Profile profile;


    @Builder
    public Users(String email, String password, String grade, String name, String nickname, String img) {
        this.email = email;
        this.password = password;
        this.grade = Grade.From(grade);
        this.authority = Authority.USERS;
        this.profile = Profile.builder()
                .name(name)
                .nickname(nickname)
                .img(img)
                .build();
    }
}
