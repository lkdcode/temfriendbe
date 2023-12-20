package com.temfriend.backend.module.activities.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.temfriend.backend.global.common.domain.BaseEntity;
import com.temfriend.backend.module.users.domain.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
public class Activities extends BaseEntity {

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
    private LocalDateTime loginTime;

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Seoul")
    private LocalDateTime postsCreateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false, unique = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Users users;

    @Builder
    public Activities(Users users) {
        this.users = users;
    }

    public void recordLoginTime() {
        if (canRecordLoginCreationTime()) {
            this.loginTime = LocalDateTime.now();
        }
    }

    public void recordPostsCreationTime() {
        if (canRecordPostCreationTime()) {
            this.postsCreateTime = LocalDateTime.now();
        }
    }

    public boolean canRecordPostCreationTime() {
        if (this.postsCreateTime == null) return true;
        LocalDateTime threeHoursAgo = LocalDateTime.now().minusHours(3);
        return this.postsCreateTime.isBefore(threeHoursAgo);
    }

    public boolean canRecordLoginCreationTime() {
        if (this.loginTime == null) return true;
        LocalDateTime threeHoursAgo = LocalDateTime.now().minusHours(6);
        return this.loginTime.isBefore(threeHoursAgo);
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
