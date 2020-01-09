DROP TABLE IF EXISTS job_trigger;
CREATE TABLE job_trigger
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    trigger_name VARCHAR(50) NOT NULL COMMENT '触发器名称',
    trigger_group VARCHAR(50) NOT NULL COMMENT '触发器分组',
    description VARCHAR(255) NOT NULL COMMENT '描述',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    priority INT NOT NULL COMMENT '优先级',
    calendar_name VARCHAR(50) NOT NULL COMMENT '',
    misfire_instruction INT NOT NULL COMMENT '',
    time_interval INT NOT NULL COMMENT '时间间隔',
    repeat_count INT NOT NULL COMMENT '重复次数',
    cron_expression VARCHAR(20) NOT NULL COMMENT 'cron 表达式',
    type TINYINT NOT NULL COMMENT '触发器类型，1-简单触发器，2-cron表达式触发器',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 0 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);


DROP TABLE IF EXISTS job_detail;
CREATE TABLE job_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    job_name VARCHAR(50) NOT NULL COMMENT '任务名称',
    job_group VARCHAR(50) NOT NULL COMMENT '任务分组',
    description VARCHAR(255) NOT NULL COMMENT '描述',
    job_class_name VARCHAR(255) NOT NULL COMMENT 'job class name',
    durability TINYINT NOT NULL COMMENT '',
    should_recover TINYINT NOT NULL COMMENT '',
    job_trigger_id BIGINT NOT NULL COMMENT 'job_trigger.id',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 0 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);