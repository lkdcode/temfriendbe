package com.temfriend.backend.modules.member.domain;

import com.temfriend.backend.global.domain.TimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "tf_member")
public class Member extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String account;

    @Column
    private String password;

    @Embedded
    private Profile profile;

    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})

}
