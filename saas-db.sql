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
    province_code VARCHAR(10) NOT NULL COMMENT '省编码',
    city_code VARCHAR(10) NOT NULL COMMENT '市编码',
    district_code VARCHAR(10) NOT NULL COMMENT '区编码',
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

INSERT INTO system_user(id, name, mobile, email, login_name, user_type, password, tenant_id, account_non_expired, account_non_locked, credentials_non_expired, enabled, create_user_id, last_update_user_id)
VALUES (-1, 'out', NULL, NULL, 'out', 3, md5('123456'), NULL, 1, 1, 1, 1, 0, 0),
    (-2, 'platform', NULL, NULL, 'platform', 3, md5('123456'), NULL, 1, 1, 1, 1, 0, 0),
    (-3, 'zd1:erp', NULL, NULL, 'zd1:erp', 3, md5('123456'), NULL, 1, 1, 1, 1, 0, 0);

DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence
(
    name VARCHAR(50) PRIMARY KEY NOT NULL COMMENT '序列名称',
    current_value INT(11) unsigned NOT NULL COMMENT '当前值',
    increment INT(11) unsigned DEFAULT '1' NOT NULL COMMENT '每次增长的值'
);

DROP FUNCTION IF EXISTS current_value;
CREATE FUNCTION current_value(seq_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    DECLARE value int;
    SET value = 0;
    SELECT current_value INTO value FROM sequence WHERE name = seq_name;
    IF value = 0 THEN
        SET value = 1;
        INSERT INTO sequence(name, current_value) VALUES(seq_name, value);
    END if;
    return value;
END;

DROP FUNCTION IF EXISTS next_value;
CREATE FUNCTION next_value(seq_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    UPDATE sequence SET current_value = current_value + increment where name = seq_name;
    return current_value(seq_name);
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

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
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
    order_id BIGINT NOT NULL COMMENT '订单ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '产品名称',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '产品规格名称',
    branch_id BIGINT COMMENT '门店ID',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    amount INT NOT NULL COMMENT '数量',
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
    goods_type TINYINT NOT NULL COMMENT '产品类型，1-设备，2-基础服务，3-增至服务',
    goods_status TINYINT NOT NULL COMMENT '状态，1-正常，2-停售',
    goods_photo_url VARCHAR(255) NOT NULL COMMENT '产品图片路径',
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

DROP TABLE IF EXISTS alipay_account;
CREATE TABLE alipay_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    account VARCHAR(50) NOT NULL COMMENT '支付宝账号',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    partner_id VARCHAR(50) NOT NULL COMMENT '合作者ID',
    store_id VARCHAR(50) COMMENT '支付宝门店ID',
    alipay_public_key VARCHAR(500) NOT NULL COMMENT '支付宝公钥',
    application_public_key VARCHAR(500) NOT NULL COMMENT '应用公钥',
    application_private_key VARCHAR(2000) NOT NULL COMMENT '应用私钥',
    sign_type ENUM('RSA', 'RSA2') NOT NULL COMMENT '借口加密方式',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

INSERT INTO alipay_account(tenant_id, branch_id, account, app_id, partner_id, alipay_public_key, application_public_key, application_private_key, sign_type, create_user_id, last_update_user_id)
VALUES (1, 1, 'zhfx2016@163.com', '2017090808618823', '2088521427937615', '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', 'RSA2', 1, 1);

INSERT INTO alipay_account(tenant_id, branch_id, account, app_id, partner_id, alipay_public_key, application_public_key, application_private_key, sign_type, create_user_id, last_update_user_id)
VALUES (2, 2, 'zhfx2016@163.com', '2016121304213325', '2088521427937615', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKRAFKr+CxOzl4kV6g3+4XEptsDF5fjvzwU9nuWqCg4G4GvO6WFMGqa71FlbzDZ8muJbSoGWqS9GHTzISqCr4SjjI/f0/NmCf+cmBWJ1DhtIwRr3sxompInAMqaFjC8YTNoSNNFKRAYvENfaK+l53O7jaxfpxTY1+CwJKMa6acbwIDAQAB', 'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMpEAUqv4LE7OXiRXqDf7hcSm2wMXl+O/PBT2e5aoKDgbga87pYUwaprvUWVvMNnya4ltKgZapL0YdPMhKoKvhKOMj9/T82YJ/5yYFYnUOG0jBGvezGiakicAypoWMLxhM2hI00UpEBi8Q19or6Xnc7uNrF+nFNjX4LAkoxrppxvAgMBAAECgYB/xnAud2bxb2GB+guWg4AMEVQf8LxZj6HYTJBa0+OvXbgEB6yNIPWrLD64S7ygkNtGaUlz/AJobXuzafrQ1NJ3FNceVDKJ5BsU+6WxODY3ldvTVBo2Mz0E4eYoxv03aYdtr2OYQvjlEe/mD0OyiqeJyYvIc4n0svIeeCofB4SNSQJBAObRFtd8WoiINVPb0jp1sEp0iGnLPCZ+rN0EBh+EyTYSxyanhATTJczegn+IjIbLuhLMGiuC56x6bP4dAwYbZAUCQQDgVXVu5vUmb1tCjOtf4KqnAi1xTt1qVuowhJUB5eLsUfgXO0z0+T1+IWIYKr5djnNbnSJrNLms+LooFhT7yPzjAkAH7KHGICTTjymViXR8QVIeHEYaq7mS8MJqjBrRtjNaQebIcvPbXoxrri/4xO1eK1xmDM/RMptVlpZrWv+hlAspAkEApr3ec3gnb1IFuwmTSchsD4aG0FmWKZxApZ9mQerlKFIk3N+u68b19fJKPzxGErP2+nlpQ9YEzJRziaggIKXbkQJBAKp22dleBHiWKy4luoXZPEgE3h+i2PO1FBDUzJ31mgNmpVaonTvUR6O920/5yc9MJtYvOE0aPafkHhjL8v4Ea8M=', 'RSA', 1, 1);

DROP TABLE IF EXISTS payment_record;
CREATE TABLE payment_record (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    order_type TINYINT NOT NULL COMMENT '1-商户购买平台产品订单，2-代理商购买平台产品订单',
    order_number VARCHAR(20) NOT NULL COMMENT '订单号',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '订单总额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    paid_amount DECIMAL(11, 3) COMMENT '实际付款金额',
    paid_type TINYINT NOT NULL COMMENT '支付类型，1-微信支付，2-支付宝支付',
    submit_time DATETIME NOT NULL COMMENT '支付请求提交时间',
    submit_user_id BIGINT NOT NULL COMMENT '提交用户id',
    pay_status TINYINT NOT NULL COMMENT '订单付款状态，1-未付款，2-已付款',
    transaction_id VARCHAR(50) COMMENT '交易单号，对应微信支付的transaction_id，支付宝支付的trade_no',
    paid_time DATETIME COMMENT '支付完成时间，对应微信支付的end_time，支付宝支付的gmt_payment',
    notify_result TINYINT COMMENT '回调结果，1-成功 2-失败',
    notify_url VARCHAR(200) DEFAULT NULL COMMENT '回调地址',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '支付记录';

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

DROP TABLE IF EXISTS wei_xin_pay_account;
CREATE TABLE wei_xin_pay_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    app_id VARCHAR(50) COMMENT '微信公众平台app id',
    mch_id VARCHAR(50) NOT NULL,
    api_secret_key VARCHAR(50) NOT NULL,
    sub_public_account_app_id VARCHAR(50) COMMENT '子商户的公众号app id',
    sub_open_platform_app_id VARCHAR(50) COMMENT '子商户的开放平台app id',
    sub_mch_id VARCHAR(50),
    acceptance_model TINYINT NOT NULL COMMENT '是否为受理关系',
    account_type TINYINT COMMENT '账号类型，1-公众号支付、扫码支付、H5支付、刷卡支付，2-APP支付账号',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT = '微信支付账号';

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
);

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
);

DROP TABLE IF EXISTS user_app_role_r;
CREATE TABLE user_app_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    app_role_id BIGINT NOT NULL COMMENT 'app role id',
    PRIMARY KEY (user_id, app_role_id)
);

DROP TABLE IF EXISTS app_role_privilege_r;
CREATE TABLE app_role_privilege_r
(
    app_role_id BIGINT NOT NULL COMMENT 'role id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (app_role_id, privilege_id)
);

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
) COMMENT = '微信公众';

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
);

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
);

insert  into `wei_xin_pay_account`(`id`,`tenant_id`,`branch_id`,`app_id`,`mch_id`,`api_secret_key`,`sub_public_account_app_id`,`sub_open_platform_app_id`,`sub_mch_id`,`acceptance_model`,`account_type`,`create_time`,`create_user_id`,`last_update_time`,`last_update_user_id`,`last_update_remark`,`deleted`) values
    (1,7,7,'wx63f5194332cc0f1b','1312787601','qingdaozhihuifangxiangruanjian12','wx63f5194332cc0f1b','wx640d01797ff7e615','1334834201',1,NULL,'2017-10-17 16:38:41',1,'2017-10-17 17:54:20',1,NULL,0),
    (2,2,2,'wx63f5194332cc0f1b','1312787601','qingdaozhihuifangxiangruanjian12',NULL,NULL,NULL,0,1,'2017-10-17 16:38:41',1,'2017-10-17 17:05:19',1,NULL,0);

INSERT INTO alipay_account(tenant_id, branch_id, account, app_id, partner_id, alipay_public_key, application_public_key, application_private_key, sign_type, create_user_id, last_update_user_id)
VALUES (4, 4, 'newellftrend@163.com', '2016051701409848', '2088911953796893', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKRAFKr+CxOzl4kV6g3+4XEptsDF5fjvzwU9nuWqCg4G4GvO6WFMGqa71FlbzDZ8muJbSoGWqS9GHTzISqCr4SjjI/f0/NmCf+cmBWJ1DhtIwRr3sxompInAMqaFjC8YTNoSNNFKRAYvENfaK+l53O7jaxfpxTY1+CwJKMa6acbwIDAQAB', 'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMpEAUqv4LE7OXiRXqDf7hcSm2wMXl+O/PBT2e5aoKDgbga87pYUwaprvUWVvMNnya4ltKgZapL0YdPMhKoKvhKOMj9/T82YJ/5yYFYnUOG0jBGvezGiakicAypoWMLxhM2hI00UpEBi8Q19or6Xnc7uNrF+nFNjX4LAkoxrppxvAgMBAAECgYB/xnAud2bxb2GB+guWg4AMEVQf8LxZj6HYTJBa0+OvXbgEB6yNIPWrLD64S7ygkNtGaUlz/AJobXuzafrQ1NJ3FNceVDKJ5BsU+6WxODY3ldvTVBo2Mz0E4eYoxv03aYdtr2OYQvjlEe/mD0OyiqeJyYvIc4n0svIeeCofB4SNSQJBAObRFtd8WoiINVPb0jp1sEp0iGnLPCZ+rN0EBh+EyTYSxyanhATTJczegn+IjIbLuhLMGiuC56x6bP4dAwYbZAUCQQDgVXVu5vUmb1tCjOtf4KqnAi1xTt1qVuowhJUB5eLsUfgXO0z0+T1+IWIYKr5djnNbnSJrNLms+LooFhT7yPzjAkAH7KHGICTTjymViXR8QVIeHEYaq7mS8MJqjBrRtjNaQebIcvPbXoxrri/4xO1eK1xmDM/RMptVlpZrWv+hlAspAkEApr3ec3gnb1IFuwmTSchsD4aG0FmWKZxApZ9mQerlKFIk3N+u68b19fJKPzxGErP2+nlpQ9YEzJRziaggIKXbkQJBAKp22dleBHiWKy4luoXZPEgE3h+i2PO1FBDUzJ31mgNmpVaonTvUR6O920/5yc9MJtYvOE0aPafkHhjL8v4Ea8M=', 'RSA', 1, 1);

1e17fcd2e668ded210f12e3a08531608
com.ftrend.ftrendpos

a3eb218f59c192ad72c92606f84eb9df

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
);

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
);

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
);

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
);

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
);

DROP TABLE IF EXISTS user_pos_role_r;
CREATE TABLE user_pos_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    pos_role_id BIGINT NOT NULL COMMENT 'pos role id',
    PRIMARY KEY (user_id, pos_role_id)
);

DROP TABLE IF EXISTS pos_role_privilege_r;
CREATE TABLE pos_role_privilege_r
(
    pos_role_id BIGINT NOT NULL COMMENT 'background id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (pos_role_id, privilege_id)
);

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
);

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
);

DROP TABLE IF EXISTS user_background_role_r;
CREATE TABLE user_background_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    background_role_id BIGINT NOT NULL COMMENT 'pos role id',
    PRIMARY KEY (user_id, background_role_id)
);

DROP TABLE IF EXISTS background_role_privilege_r;
CREATE TABLE background_role_privilege_r
(
    background_role_id BIGINT NOT NULL COMMENT 'background id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (background_role_id, privilege_id)
);

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
) COMMENT = '微信支付账号';