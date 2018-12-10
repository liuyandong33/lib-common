DROP TABLE IF EXISTS cluster;
CREATE TABLE cluster
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    `name` VARCHAR(20) NOT NULL COMMENT '集群名称',
    `type` TINYINT NOT NULL COMMENT '集群类型，1-zookeeper 集群',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '集群表';

DROP TABLE IF EXISTS zookeeper_node;
CREATE TABLE zookeeper_node
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    cluster_id BIGINT NOT NULL COMMENT '集群ID',
    host_name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    zookeeper_home VARCHAR(255) NOT NULL COMMENT 'zookeeper 主目录',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'zookeeper 节点';

DROP TABLE IF EXISTS kafka_node;
CREATE TABLE kafka_node
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    cluster_id BIGINT NOT NULL COMMENT '集群ID',
    host_name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    kafka_home VARCHAR(255) NOT NULL COMMENT 'zookeeper 主目录',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'kafka 节点';

DROP TABLE IF EXISTS `host`;
CREATE TABLE `host`
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    `type` INT NOT NULL COMMENT '主机类型，1-真机，2-虚拟机',
    parent_id BIGINT NOT NULL COMMENT '宿主机id',
    `name` VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    disk_size INT NOT NULL COMMENT '硬盘大小，单位GB',
    cpu_core_quantity INT NOT NULL COMMENT 'CPU 核心数量',
    memory_size INT NOT NULL COMMENT '内存大小，单位B',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '主机';

DROP TABLE IF EXISTS my_sql_configuration;
CREATE TABLE my_sql_configuration
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(200) NOT NULL COMMENT '名称',
    `value` VARCHAR(200) NOT NULL COMMENT '值',
    `type` VARCHAR(20) NOT NULL COMMENT 'mysqld, client',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'mysql 配置';

DROP TABLE IF EXISTS network_configuration;
CREATE TABLE network_configuration
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `name` VARCHAR(50) NOT NULL COMMENT '配置名称',
    `value` VARCHAR(50) NOT NULL COMMENT '配置值',
    `comment` VARCHAR(255) NOT NULL COMMENT '注释',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么回调信息';