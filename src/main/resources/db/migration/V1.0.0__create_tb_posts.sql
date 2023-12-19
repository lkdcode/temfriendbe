DROP TABLE if EXISTS posts;

CREATE TABLE posts (
    id           BIGINT          NOT NULL        AUTO_INCREMENT,
    created_at   DATETIME(6),
    updated_at   DATETIME(6),
    status       VARCHAR(255)    NOT NULL,
    content      VARCHAR(255)    NOT NULL,
    title        VARCHAR(255)    NOT NULL,
    users_id     BIGINT          NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;