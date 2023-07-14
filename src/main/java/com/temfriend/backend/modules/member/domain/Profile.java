package com.temfriend.backend.modules.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Profile {

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String img;
}
