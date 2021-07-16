CREATE TABLE `posts`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'identifier',
    `desc`        VARCHAR(255)     NOT NULL,
    `image`       VARCHAR(255)     NOT NULL,
    `user_id`      VARCHAR(255)     NOT NULL,
    `like_count`  Int(10)          NOT NULL DEFAULT 0,
    `share_count` Int(10)          NOT NULL DEFAULT 0,
    `created_at`  TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
