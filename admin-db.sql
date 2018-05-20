DROP TABLE IF EXISTS host;
CREATE TABLE host
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    type INT NOT NULL COMMENT '主机类型，1-真机，2-虚拟机',
    parent_id BIGINT COMMENT '宿主机id',
    name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    password VARCHAR(20) NOT NULL COMMENT '密码',
    disk_size INT NOT NULL COMMENT '硬盘大小，单位GB',
    cup_core_quantity INT NOT NULL COMMENT 'CPU 核心数量',
    memory_size INT NOT NULL COMMENT '内存大小，单位B',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
);