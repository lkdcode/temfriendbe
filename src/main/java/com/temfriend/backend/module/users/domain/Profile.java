package com.temfriend.backend.module.users.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Profile {
    private enum Grade {
        BRONZE, SILVER, GOLD
    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private Grade grade;

    @Builder
    public Profile(String name, String nickname, String img) {
        this.name = name;
        this.nickname = nickname;
        this.img = img;
        this.grade = Grade.BRONZE;
    }

    public void promoteGrade() {
        switch (this.grade) {
            case BRONZE -> this.grade = Grade.SILVER;
            case SILVER -> this.grade = Grade.GOLD;
        }
    }
}
