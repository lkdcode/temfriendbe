package com.temfriend.backend.module.users.domain;

import com.temfriend.backend.global.common.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.rule.Authority;
import com.temfriend.backend.module.users.domain.rule.Grade;
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
    public Users(String email, String password, String name, String nickname, String img) {
        this.email = email;
        this.password = password;
        this.grade = Grade.BRONZE;
        this.authority = Authority.USERS;
        this.profile = Profile.builder()
                .name(name)
                .nickname(nickname)
                .img(img)
                .build();
    }

    public String getName() {
        return this.profile.getName();
    }

    public String getNickname() {
        return this.profile.getNickname();
    }

    public String getImg() {
        return this.profile.getImg();
    }

    public String getAuthority() {
        return this.authority.name();
    }

    public String getGrade() {
        return this.grade.name();
    }

    public String getStatus() {
        return super.getStatus();
    }

    @Override
    public void remove() {
        super.markAsDeleted();
    }

    @Override
    public void restored() {
        super.markAsRestored();
    }
}
