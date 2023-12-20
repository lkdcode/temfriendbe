DROP TABLE if EXISTS points;

create table points (
    id           BIGINT          NOT NULL        AUTO_INCREMENT,
    created_at   DATETIME(6),
    updated_at   DATETIME(6),
    status       VARCHAR(255)    NOT NULL,
    users_score  BIGINT          NOT NULL,
    users_id     BIGINT          NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;