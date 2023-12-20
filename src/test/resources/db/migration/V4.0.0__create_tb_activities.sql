DROP TABLE if EXISTS activities;

create table activities (
    id                   BIGINT          NOT NULL        AUTO_INCREMENT,
    created_at           DATETIME(6),
    updated_at           DATETIME(6),
    status               VARCHAR(255)    NOT NULL,
    login_time           DATETIME(6),
    posts_create_time    DATETIME(6),
    users_id             BIGINT          NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;