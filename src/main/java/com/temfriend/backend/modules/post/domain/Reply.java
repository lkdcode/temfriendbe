package com.temfriend.backend.modules.post.domain;

import com.temfriend.backend.global.domain.TimeEntity;
import com.temfriend.backend.modules.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "Reply")
@Table(name = "tf_reply")
public class Reply extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(name = "reply_content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
