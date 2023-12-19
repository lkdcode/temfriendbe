DROP TABLE if EXISTS users;

CREATE TABLE users (
    id           BIGINT          NOT NULL        AUTO_INCREMENT,
    created_at   DATETIME(6),
    updated_at   DATETIME(6),
    status       VARCHAR(255)    NOT NULL,
    authority    VARCHAR(255)    NOT NULL,
    email        VARCHAR(255)    NOT NULL        UNIQUE,
    grade        VARCHAR(255)    NOT NULL,
    password     VARCHAR(255)    NOT NULL,
    img          VARCHAR(255)    NOT NULL,
    name         VARCHAR(255)    NOT NULL,
    nickname     VARCHAR(255)    NOT NULL        UNIQUE,
    PRIMARY KEY (id)
) ENGINE=InnoDB;