package com.temfriend.backend.modules.member.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Embeddable
public class Profile {

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_nickname", nullable = false)
    private String nickname;

    @Column(name = "member_img", nullable = false)
    private String img;


}
