package com.temfriend.backend.module.replies.domain;

import com.temfriend.backend.global.common.domain.BaseEntity;
import com.temfriend.backend.module.posts.domain.Posts;
import com.temfriend.backend.module.users.domain.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Replies extends BaseEntity {
    // TODO : 댓글 내용 길이 제한
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Posts posts;

    @Builder
    public Replies(String content, Users users, Posts posts) {
        this.content = content;
        this.users = users;
        this.posts = posts;
    }

    @Override
    protected void remove() {
        super.markAsDeleted();
    }

    @Override
    protected void restored() {
        super.markAsRestored();
    }
}
