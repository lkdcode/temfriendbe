package com.temfriend.backend.modules.member.domain;

import com.temfriend.backend.global.domain.TimeEntity;
import com.temfriend.backend.modules.member.domain.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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

    @Column(name = "member_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

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
