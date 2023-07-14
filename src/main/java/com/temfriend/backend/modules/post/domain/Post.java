package com.temfriend.backend.modules.post.domain;

import com.temfriend.backend.global.domain.TimeEntity;
import com.temfriend.backend.modules.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity(name = "tf_post")
public class Post extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column
    private String content;
    @Column
    private LocalDateTime startDt;
    @Column
    private LocalDateTime endDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "img_id")
    @OrderBy("id asc")
    private List<Img> imgList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "reply_id")
    @OrderBy("id desc")
    private List<Reply> replyList;
}
