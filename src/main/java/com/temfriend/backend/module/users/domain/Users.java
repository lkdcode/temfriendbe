package com.temfriend.backend.module.users.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.temfriend.backend.global.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.enums.Authority;
import com.temfriend.backend.module.users.domain.enums.Grade;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Users extends BaseEntity {

    @JsonProperty(access = READ_ONLY)
    @Column(nullable = false, unique = true)
    private String email;
    @JsonProperty(access = READ_ONLY)
    @Column(nullable = false)
    private String password;
    @JsonProperty(access = READ_ONLY)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @JsonProperty(access = READ_ONLY)
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
