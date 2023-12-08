package com.temfriend.backend.module.posts.domain;

import com.temfriend.backend.global.common.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Posts extends BaseEntity {
    // TODO : 제목과 내용 길이 제한
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Users users;

    @Builder
    public Posts(String title, String content, Users users) {
        this.title = title;
        this.content = content;
        this.users = users;
    }

    public void update(String title, String content) {
        if (title != null) {
            this.title = title;
        }
        if (content != null) {
            this.content = content;
        }
    }

    @Override
    public void remove() {
        super.markAsDeleted();
    }

    @Override
    public void restored() {
        super.markAsRestored();
    }
}
