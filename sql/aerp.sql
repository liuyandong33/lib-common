DROP TABLE IF EXISTS tenant;
CREATE TABLE tenant
(
    id BIGINT PRIMARY KEY, --ID
    code VARCHAR(20), --商户编码
    name VARCHAR(20), --商户名称
    business VARCHAR(10), --业态，1-餐饮，2-零售
    province_code VARCHAR(10), --省编码
    province_name VARCHAR(10), --省名称
    city_code VARCHAR(10), --市编码
    city_name VARCHAR(10), --市名称
    district_code VARCHAR(10), --区编码
    district_name VARCHAR(10), --区名称
    address VARCHAR(255), --门店详细地址
    linkman VARCHAR(20), --联系人
    contact_phone VARCHAR(20), --联系电话
    email VARCHAR(50), --邮箱地址
    partition_code VARCHAR(20), --分区码
    tenant_type TINYINT, --商户类型，1-标准版商户，2-单机版商户
    vip_shared_type TINYINT, --会员共享类型，1-全部共享，2-全部独立，3-分组共享
    agent_id BIGINT, --代理商ID
    used_channel_type TINYINT, --商户使用的支付通道类型，1-原生支付，2-米雅，3-新大陆，4-联动
    dada_source_id BIGINT, --达达商户ID
    jddj_vender_id VARCHAR(20), --京东到家商家ID
    jddj_app_key VARCHAR(50), --京东到家授权应用app key
    jddj_app_secret VARCHAR(50), --京东到家授权应用app secret
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除
);

DROP TABLE IF EXISTS system_user;
CREATE TABLE system_user
(
    id BIGINT PRIMARY KEY, --ID,
    name VARCHAR(20), --员工姓名
    mobile VARCHAR(20), --手机号码,
    email VARCHAR(20), --邮箱,
    login_name VARCHAR(20), --登录名,
    user_type TINYINT, --员工类型，1-商户主账号，2-商户员工，3-代理商
    password VARCHAR(50), --登录密码
    wei_xin_public_platform_open_id VARCHAR(50), --微信公众平台open id
    wei_xin_open_platform_open_id VARCHAR(50), --微信开放平台open id
    tenant_id BIGINT, -- 商户ID
    agent_id BIGINT, -- 代理商ID
    account_non_expired TINYINT, --账户是否没有过期，1-没有过期，0-已经过期
    account_non_locked TINYINT, -- 账户是否没有锁定，1-没有锁定，0-已经锁定
    credentials_non_expired TINYINT, --账户凭证是否没有过期，1-没有过期，0-已经过期
    enabled TINYINT, --账户是否启用，1-启用，0-禁用
    created_time VARCHAR(20),--创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除
);

DROP TABLE IF EXISTS branch;
CREATE TABLE branch
(
    id BIGINT PRIMARY KEY, --ID
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    code VARCHAR(20), --门店编码
    name VARCHAR(20), --门店名称
    type TINYINT, --1-总部，2-直营店，3-加盟店，4-配送中心
    status TINYINT, --状态，1-启用，2-停用
    province_code VARCHAR(10), --省编码
    province_name VARCHAR(10), --省名称
    city_code VARCHAR(10), --市编码
    city_name VARCHAR(10), --市名称
    district_code VARCHAR(10), --区编码
    district_name VARCHAR(10), --区名称
    address VARCHAR(255), --门店详细地址
    longitude VARCHAR(20), --经度
    latitude VARCHAR(20), --纬度
    linkman VARCHAR(20), --联系人
    contact_phone VARCHAR(20), --联系电话
    eleme_account_type TINYINT, --1-连锁账号，2-独立账号
    shop_id BIGINT, --饿了么店铺ID
    smart_restaurant_status TINYINT, --微餐厅状态，1-正常，2-禁用
    app_auth_token VARCHAR(50), --门店绑定的授权token
    poi_id VARCHAR(10), --美团门店ID
    poi_name VARCHAR(20), --美团门店名称
    vip_group_id BIGINT, --会员分组ID
    business_times VARCHAR(255), --营业时间
    dada_origin_shop_id VARCHAR(50), --达达门店ID
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT DEFAULT 0 --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS pos;
CREATE TABLE pos
(
    id BIGINT PRIMARY KEY, --ID
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编号
    branch_id BIGINT, --门店ID
    branch_code VARCHAR(20), --门店编码
    user_id BIGINT, --用户ID
    device_id VARCHAR(50), --阿里云推送服务设备ID
    type VARCHAR(10), --pos 类型，安卓-android，苹果-ios
    version VARCHAR(10), --pos 版本号
    online TINYINT, --是否在线，1-在线，0-不在线
    cloud_push_device_id VARCHAR(50), --阿里云推送服务设备ID
    mqtt_client_id VARCHAR(100), --MQTT Client Id
    mqtt_token VARCHAR(1000), --MQTT Token
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS oauth_token;
CREATE TABLE oauth_token
(
    id INTEGER PRIMARY KEY AUTOINCREMENT, --ID
    access_token VARCHAR(50), --access token
    token_type VARCHAR(20), --token type
    refresh_token VARCHAR(50), --refresh token
    expires_in INT(50), --expires in
    scope VARCHAR(20), --scope
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 --是否删除，0-未删除，1-已删除'
);