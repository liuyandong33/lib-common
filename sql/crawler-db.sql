CREATE DATABASE `crawler-db`;

DROP TABLE IF EXISTS tou_tiao_signature;
CREATE TABLE tou_tiao_signature
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    user_Id BIGINT NOT NULL COMMENT '用户ID',
    max_behot_time BIGINT NOT NULL COMMENT '时间参数',
    signature VARCHAR(50) NOT NULL COMMENT '签名',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '今日头条签名';