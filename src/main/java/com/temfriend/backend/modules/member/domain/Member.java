package com.temfriend.backend.modules.member.domain;

import com.temfriend.backend.global.domain.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "Member")
@Table(name = "tf_member")
public class Member extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_account", nullable = false)
    private String account;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Embedded
    private Profile profile;

    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})

    @Builder
    public Member(String account, String password, Profile profile) {
        this.account = account;
        this.password = password;
        this.profile = profile;
    }

    public String getName() {
        return profile.getName();
    }

    public String getImg() {
        return profile.getImg();
    }

    public String getNickname() {
        return profile.getNickname();
    }

}
