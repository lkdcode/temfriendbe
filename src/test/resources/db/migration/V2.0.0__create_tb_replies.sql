DROP TABLE if EXISTS replies;

create table replies (
    id           BIGINT          NOT NULL        AUTO_INCREMENT,
    created_at   DATETIME(6),
    updated_at   DATETIME(6),
    status       VARCHAR(255)    NOT NULL,
    content      VARCHAR(255)    NOT NULL,
    posts_id     BIGINT          NOT NULL,
    users_id     BIGINT          NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;