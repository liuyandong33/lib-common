DROP TABLE IF EXISTS system_partition;
CREATE TABLE system_partition
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    deployment_environment VARCHAR(20) NOT NULL COMMENT '部署环境',
    partition_code VARCHAR(20) NOT NULL COMMENT '分区码',
    `type` TINYINT NOT NULL COMMENT '服务类型，1-公共服务，2-分区服务',
    service_name VARCHAR(20) NOT NULL COMMENT '服务名称',
    service_domain VARCHAR(200) NOT NULL COMMENT '服务地址',
    outside_service_domain VARCHAR(200) NOT NULL COMMENT '外网服务地址',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户ID',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新用户id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '系统分区表';

DROP TABLE IF EXISTS configuration;
CREATE TABLE configuration (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    deployment_environment VARCHAR(20) NOT NULL COMMENT '部署环境',
    partition_code VARCHAR(20) NOT NULL COMMENT '分区码',
    service_name VARCHAR(20) NOT NULL COMMENT '服务名称',
    configuration_key VARCHAR(200) COMMENT '配置key',
    configuration_value VARCHAR(200) COMMENT '配置value',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '配置表';

DROP TABLE IF EXISTS tenant;
CREATE TABLE tenant
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `code` VARCHAR(20) NOT NULL COMMENT '商户编码',
    `name` VARCHAR(20) NOT NULL COMMENT '商户名称',
    mobile VARCHAR(20) NOT NULL COMMENT '联系电话',
    email VARCHAR(20) NOT NULL COMMENT '邮箱',
    linkman VARCHAR(20) NOT NULL COMMENT '联系人',
    business VARCHAR(10) NOT NULL COMMENT '业态',
    partition_code VARCHAR(20) NOT NULL COMMENT '分区码',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    tenant_type TINYINT NOT NULL COMMENT '商户类型，1-标准版商户，2-单机版商户',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '商户表';

DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`
(
    id BIGINT NOT NULL  AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `name` VARCHAR(20) NOT NULL COMMENT '员工姓名',
    mobile VARCHAR(20) COMMENT '手机号码',
    email VARCHAR(20) COMMENT '邮箱',
    `login_name` VARCHAR(20) COMMENT '登录名',
    user_type TINYINT NOT NULL COMMENT '员工类型，1-商户主账号，2-商户员工',
    `password` VARCHAR(50) NOT NULL COMMENT '登录密码',
    wei_xin_public_platform_open_id VARCHAR(50) COMMENT '微信公众平台open id',
    wei_xin_open_platform_open_id VARCHAR(50) COMMENT '微信开放平台open id',
    tenant_id BIGINT COMMENT '商户ID',
    account_non_expired TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否没有过期，1-没有过期，0-已经过期',
    account_non_locked TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否没有锁定，1-没有锁定，0-已经锁定',
    credentials_non_expired TINYINT NOT NULL DEFAULT 1 COMMENT '账户凭证是否没有过期，1-没有过期，0-已经过期',
    enabled TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否启用，1-启用，0-禁用',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '系统用户表';

DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence
(
    name VARCHAR(50) PRIMARY KEY NOT NULL COMMENT '序列名称',
    current_value INT(11) unsigned NOT NULL COMMENT '当前值',
    increment INT(11) unsigned DEFAULT '1' NOT NULL COMMENT '每次增长的值'
);

DROP FUNCTION IF EXISTS current_value;
CREATE FUNCTION current_value(sequence_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    DECLARE value int;
    SET value = 0;
    SELECT current_value INTO value FROM sequence WHERE name = sequence_name;
    IF value = 0 THEN
        SET value = 1;
        INSERT INTO sequence(name, current_value) VALUES(sequence_name, value);
    END if;
    return value;
END;

DROP FUNCTION IF EXISTS next_value;
CREATE FUNCTION next_value(sequence_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    UPDATE sequence SET current_value = current_value + increment where name = sequence_name;
    return current_value(sequence_name);
END ;

DROP TABLE IF EXISTS wei_xin_pay_account;
CREATE TABLE wei_xin_pay_account
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    app_id VARCHAR(50) COMMENT '微信公众平台app id',
    mch_id VARCHAR(50) NOT NULL COMMENT '微信支付商户号',
    api_secret_key VARCHAR(50) NOT NULL,
    sub_public_account_app_id VARCHAR(50) COMMENT '子商户的公众号app id',
    sub_open_platform_app_id VARCHAR(50) COMMENT '子商户的开放平台app id',
    sub_mch_id VARCHAR(50),
    operation_certificate VARCHAR(5000) COMMENT '操作证书',
    operation_certificate_password VARCHAR(20) COMMENT '操作证书密码',
    rsa_public_key VARCHAR(500) COMMENT 'rsa 公钥',
    acceptance_model TINYINT NOT NULL COMMENT '是否为受理关系',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '微信支付账号';

DROP TABLE IF EXISTS alipay_account;
CREATE TABLE alipay_account(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    account VARCHAR(50) NOT NULL COMMENT '支付宝账号',
    app_id VARCHAR(50) NOT NULL COMMENT '支付宝appid',
    partner_id VARCHAR(50) NOT NULL COMMENT '支付宝合作者ID',
    store_id VARCHAR(50) COMMENT '支付宝门店ID',
    alipay_public_key VARCHAR(500) NOT NULL COMMENT '支付宝公钥',
    application_public_key VARCHAR(500) NOT NULL COMMENT '应用公钥',
    application_private_key VARCHAR(2000) NOT NULL COMMENT '应用私钥',
    sign_type ENUM('RSA', 'RSA2') NOT NULL COMMENT '签名方式',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '支付宝账号';

DROP TABLE IF EXISTS alipay_open_auth_token;
CREATE TABLE alipay_open_auth_token
(
	id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
	app_id VARCHAR(50) NOT NULL COMMENT '支付宝app id',
	app_auth_token VARCHAR(50) NOT NULL,
	user_id VARCHAR(50) NOT NULL COMMENT '支付宝用户id',
	auth_app_id VARCHAR(50) NOT NULL COMMENT '授权app id',
	expires_in INT NOT NULL COMMENT 'token 有效时间',
	re_expires_in INT NOT NULL COMMENT '刷新token有效时间',
	app_refresh_token VARCHAR(50) NOT NULL COMMENT '刷新token',
	create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
	create_user_id BIGINT NOT NULL COMMENT '创建人id',
	last_update_time DATETIME DEFAULT now() NOT NULL COMMENT '最后更新时间',
	last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
	last_update_remark VARCHAR(255) COMMENT '最后更新备注',
	deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '支付宝token';

DROP TABLE IF EXISTS notify_record;
CREATE TABLE notify_record
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    order_number VARCHAR(50) COMMENT '订单号',
    refund_order_number VARCHAR(50) COMMENT '退款单号',
    notify_url VARCHAR(255) NOT NULL COMMENT '回调地址',
    notify_result TINYINT COMMENT '回调结果，1-未回调 2-回调成功，3-回调失败',
    external_system_notify_request_body TEXT COMMENT '外部系统异步通知请求参数',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '回调记录';

DROP TABLE IF EXISTS eleme_authorized_tenant;
CREATE TABLE eleme_authorized_tenant (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT(20) DEFAULT NULL COMMENT '商户ID',
    branch_id BIGINT(20) DEFAULT NULL COMMENT '门店ID',
    access_token VARCHAR(200) DEFAULT NULL COMMENT 'access_token',
    refresh_token VARCHAR(200) DEFAULT NULL COMMENT 'refresh_token',
    expires_in INT DEFAULT NULL COMMENT 'expires_in',
    token_type VARCHAR(20) DEFAULT NULL COMMENT 'token_type',
    fetch_token_time DATETIME DEFAULT NULL COMMENT '获取token时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id INT(11) NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id INT(11) NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '饿了么授权商户表';

DROP TABLE IF EXISTS eleme_branch_mapping;
CREATE TABLE eleme_branch_mapping (
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT(20) NOT NULL COMMENT '商户ID',
    branch_id BIGINT(20) NOT NULL COMMENT '门店ID',
    shop_id VARCHAR(20) NOT NULL COMMENT '饿了么门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '饿了么门店映射表';

DROP TABLE IF EXISTS order_info;
CREATE TABLE order_info (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    order_type TINYINT NOT NULL COMMENT '订单类型，1-商户订单，2-代理商订单',
    order_status TINYINT NOT NULL COMMENT '订单状态，1-未付款，2-已付款',
    tenant_id BIGINT COMMENT '商户ID',
    agent_id BIGINT COMMENT '代理商ID',
    total_amount DECIMAL(11, 3) COMMENT '总金额',
    discount_amount DECIMAL(11, 3) COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) COMMENT '应付金额',
    paid_amount DECIMAL(11, 3) COMMENT '实付金额',
    paid_type TINYINT COMMENT '支付类型，1-微信支付，2-支付宝支付',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '订单表';

DROP TABLE IF EXISTS order_detail;
CREATE TABLE order_detail (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    order_info_id BIGINT NOT NULL COMMENT '订单ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '产品名称',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '产品规格名称',
    branch_id BIGINT COMMENT '门店ID',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    quantity INT NOT NULL COMMENT '数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '订单明细表';

DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    name VARCHAR(20) NOT NULL COMMENT '产品名称',
    type TINYINT NOT NULL COMMENT '产品类型，1-设备，2-基础服务，3-增值服务',
    status TINYINT NOT NULL COMMENT '状态，1-正常，2-停售',
    photo_url VARCHAR(255) NOT NULL COMMENT '产品图片路径',
    metering_mode TINYINT NOT NULL COMMENT '计量方式，1-按时间，按数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '产品表';

DROP TABLE IF EXISTS goods_specification;
CREATE TABLE goods_specification (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `name` VARCHAR(20) NOT NULL COMMENT '产品名称',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    allow_tenant_buy TINYINT NOT NULL COMMENT '是否允许商户购买',
    allow_agent_buy TINYINT NOT NULL COMMENT '是否允许代理商购买',
    renewal_time TINYINT COMMENT '续费时间',
    tenant_price DECIMAL(11, 3) COMMENT '商户价格',
    agent_price DECIMAL(11, 3) COMMENT '代理商价格',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '产品明细表';

CREATE TABLE logging_event(
    timestmp bigint(20) NOT NULL,
    formatted_message text NOT NULL,
    logger_name varchar(254) NOT NULL,
    level_string varchar(254) NOT NULL,
    thread_name varchar(254) DEFAULT NULL,
    reference_flag smallint(6) DEFAULT NULL,
    arg0 varchar(254) DEFAULT NULL,
    arg1 varchar(254) DEFAULT NULL,
    arg2 varchar(254) DEFAULT NULL,
    arg3 varchar(254) DEFAULT NULL,
    caller_filename varchar(254) NOT NULL,
    caller_class varchar(254) NOT NULL,
    caller_method varchar(254) NOT NULL,
    caller_line char(4) NOT NULL,
    event_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (event_id)
);


CREATE TABLE logging_event_exception (
    event_id bigint(20) NOT NULL,
    i smallint(6) NOT NULL,
    trace_line varchar(254) NOT NULL,
    PRIMARY KEY (event_id, i)
);


CREATE TABLE logging_event_property (
    event_id bigint(20) NOT NULL,
    mapped_key varchar(254) NOT NULL,
    mapped_value text,
    PRIMARY KEY (event_id, mapped_key)
);

DROP TABLE IF EXISTS wei_xin_public_account;
CREATE TABLE wei_xin_public_account
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT(20) NOT NULL COMMENT '商户ID',
    branch_id BIGINT(20) NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '微信公众号名称',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    app_secret VARCHAR(50) NOT NULL COMMENT 'app secret',
    original_id VARCHAR(50) NOT NULL COMMENT '原始id',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT(20) NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT(20) NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT(4) DEFAULT '0' NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '微信公众号';

DROP TABLE IF EXISTS app_privilege;
CREATE TABLE app_privilege
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    privilege_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    privilege_name VARCHAR(20) NOT NULL COMMENT '权限名称',
    service_name VARCHAR(50) COMMENT '服务名称',
    controller_name VARCHAR(50) COMMENT 'controller name',
    action_name VARCHAR(50) COMMENT 'action name',
    parent_id BIGINT NOT NULL COMMENT '父级权限ID',
    remark VARCHAR(255) COMMENT '备注',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'APP权限';

DROP TABLE IF EXISTS app_role;
CREATE TABLE app_role
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'app 角色';

DROP TABLE IF EXISTS user_app_role_r;
CREATE TABLE user_app_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    app_role_id BIGINT NOT NULL COMMENT 'app role id',
    PRIMARY KEY (user_id, app_role_id)
) COMMENT '用户与app角色中间表';

DROP TABLE IF EXISTS app_role_privilege_r;
CREATE TABLE app_role_privilege_r
(
    app_role_id BIGINT NOT NULL COMMENT 'role id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (app_role_id, privilege_id)
) COMMENT 'app 角色与app权限关联表';

DROP TABLE IF EXISTS wei_xin_public_platform_application;
CREATE TABLE wei_xin_public_platform_application
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    app_secret VARCHAR(50) NOT NULL COMMENT 'app secret',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT = '微信开放平台应用';

DROP TABLE IF EXISTS tenant_secret_key;
CREATE TABLE tenant_secret_key
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    public_key VARCHAR(500) NOT NULL COMMENT '公钥',
    private_key VARCHAR(2000) NOT NULL COMMENT '私钥',
    platform_public_key VARCHAR(500) NOT NULL COMMENT '平台公钥',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商户秘钥';

DROP TABLE IF EXISTS eleme_callback_message;
CREATE TABLE eleme_callback_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    request_id VARCHAR(50) NOT NULL COMMENT '请求ID',
    `type` TINYINT NOT NULL COMMENT '消息类型',
    app_id BIGINT NOT NULL COMMENT 'app id',
    message TEXT NOT NULL COMMENT 'message',
    shop_id BIGINT NOT NULL COMMENT 'shop id',
    `timestamp` BIGINT NOT NULL COMMENT 'timestamp',
    signature VARCHAR(50) NOT NULL COMMENT 'signature',
    user_id BIGINT NOT NULL COMMENT 'user id',
    message_md5 VARCHAR(50) NOT NULL COMMENT 'message md5值',
    handle_result TINYINT NOT NULL COMMENT '处理结果，1-成功，2-失败',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么回调信息';

DROP TABLE IF EXISTS um_pay_account;
CREATE TABLE um_pay_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    um_pay_id VARCHAR(20) NOT NULL COMMENT 'um pay id',
    merchant_private_key VARCHAR(2000) NOT NULL COMMENT '商户私钥',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '联动支付账号';

DROP TABLE IF EXISTS wei_xin_template_message;
CREATE TABLE wei_xin_template_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    app_secret VARCHAR(50) NOT NULL COMMENT 'app secret',
    original_id VARCHAR(50) NOT NULL COMMENT '原始id',
    template_message_id VARCHAR(50) NOT NULL COMMENT '模版ID',
    wei_xin_template_message_code VARCHAR(10) NOT NULL COMMENT '模板消息编码',
    wei_xin_template_message_keys VARCHAR(200) NOT NULL COMMENT '模板的key数组，中间以,隔开',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '微信模板消息';

DROP TABLE IF EXISTS tenant_goods;
CREATE TABLE tenant_goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    goods_id BIGINT NOT NULL COMMENT '产品id',
    expiry_time DATETIME NOT NULL COMMENT '过期时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '商户产品表';

DROP TABLE IF EXISTS pos_privilege;
CREATE TABLE pos_privilege
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    privilege_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    privilege_name VARCHAR(20) NOT NULL COMMENT '权限名称',
    service_name VARCHAR(50) COMMENT '服务名称',
    controller_name VARCHAR(50) COMMENT 'controller name',
    action_name VARCHAR(50) COMMENT 'action name',
    parent_id BIGINT NOT NULL COMMENT '父级权限ID',
    remark VARCHAR(255) COMMENT '备注',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'POS权限';

DROP TABLE IF EXISTS pos_role;
CREATE TABLE pos_role
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    role_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'pos角色';

DROP TABLE IF EXISTS user_pos_role_r;
CREATE TABLE user_pos_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    pos_role_id BIGINT NOT NULL COMMENT 'pos role id',
    PRIMARY KEY (user_id, pos_role_id)
) COMMENT '用户与pos角色中间表';

DROP TABLE IF EXISTS pos_role_privilege_r;
CREATE TABLE pos_role_privilege_r
(
    pos_role_id BIGINT NOT NULL COMMENT 'background id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (pos_role_id, privilege_id)
) COMMENT 'pos角色与pos权限中间表';

DROP TABLE IF EXISTS background_privilege;
CREATE TABLE background_privilege
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    privilege_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    privilege_name VARCHAR(20) NOT NULL COMMENT '权限名称',
    privilege_type TINYINT NOT NULL COMMENT '1-开放权限，2-需要权限，3-需要认证，4-一级菜单',
    service_name VARCHAR(50) NOT NULL COMMENT '服务名称',
    controller_name VARCHAR(50) COMMENT 'controller name',
    action_name VARCHAR(50) COMMENT 'action name',
    parent_id BIGINT NOT NULL COMMENT '父级权限ID',
    hidden TINYINT NOT NULL COMMENT '是否在权限设置页面隐藏，1-隐藏，2-不隐藏',
    remark VARCHAR(255) COMMENT '备注',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '后台权限';

DROP TABLE IF EXISTS background_role;
CREATE TABLE background_role
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    role_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '后台角色';

DROP TABLE IF EXISTS user_background_role_r;
CREATE TABLE user_background_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    background_role_id BIGINT NOT NULL COMMENT 'pos role id',
    PRIMARY KEY (user_id, background_role_id)
) COMMENT '用户与后台角色中间表';

DROP TABLE IF EXISTS background_role_privilege_r;
CREATE TABLE background_role_privilege_r
(
    background_role_id BIGINT NOT NULL COMMENT 'background id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (background_role_id, privilege_id)
) COMMENT '后台角色与后台权限中间表';

DROP TABLE IF EXISTS bank_account;
CREATE TABLE bank_account
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    bank_card_number VARCHAR(50) NOT NULL COMMENT '银行卡卡号',
    cardholder VARCHAR(50) NOT NULL COMMENT '持卡人',
    bank_name VARCHAR(20) NOT NULL COMMENT '开户行',
    bank_code VARCHAR(20) NOT NULL COMMENT '开户行编号',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '银行账号';

DROP TABLE IF EXISTS miya_pay_account;
CREATE TABLE miya_pay_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '商户ID',
    account VARCHAR(50) NOT NULL COMMENT '米雅账号',
    miya_pay_key VARCHAR(50) NOT NULL COMMENT '米雅秘钥',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '米雅支付账号';

DROP TABLE IF EXISTS activity;
CREATE TABLE activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(20) NOT NULL COMMENT '活动名称',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    `type` TINYINT NOT NULL COMMENT '活动类型，1-特价商品活动',
    `status` TINYINT NOT NULL COMMENT '活动状态，1-未执行，2-执行中，3-已终止，4-已过期',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '活动';

DROP TABLE IF EXISTS special_goods_activity;
CREATE TABLE special_goods_activity (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    goods_id BIGINT NOT NULL COMMENT '商品id',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格id',
    discount_type TINYINT NOT NULL COMMENT '优惠方式，1-特价，2-折扣',
    tenant_special_price DECIMAL(11, 3) COMMENT '商户特价金额',
    agent_special_price DECIMAL(11, 3) COMMENT '代理商特价金额',
    tenant_discount_rate DECIMAL(5, 2) COMMENT '商户折扣率',
    agent_discount_rate DECIMAL(5, 2) COMMENT '代理商折扣率',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT(20) NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '特价商品活动';