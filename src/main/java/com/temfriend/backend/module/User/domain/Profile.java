package com.temfriend.backend.module.User.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Profile {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String img;

    @Builder
    public Profile(String name, String nickname, String img) {
        this.name = name;
        this.nickname = nickname;
        this.img = img;
    }
}
