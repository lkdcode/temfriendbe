package com.temfriend.backend.module.points.domain;

import com.temfriend.backend.global.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.Users;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Points extends BaseEntity {

    @Column(nullable = false)
    private Long usersScore = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false, unique = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Users users;

    private Points(Users users) {
        this.users = users;
    }

    public static Points newInstance(Users users) {
        return new Points(users);
    }

    public void addLogInScore() {
        this.usersScore += ScoreList.LOG_IN.getScore();
    }

    public void addPostsCreateScore() {
        this.usersScore += ScoreList.POSTS_CREATE.getScore();
    }

    @Getter
    @RequiredArgsConstructor
    private enum ScoreList {
        POSTS_CREATE(30L),
        LOG_IN(50L),
        ;
        private final Long score;
    }
}
