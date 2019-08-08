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

DROP TABLE IF EXISTS config;
CREATE TABLE config
(
    id INTEGER PRIMARY KEY AUTOINCREMENT, --ID
    name TEXT, --name
    value TEXT --value
);

DROP TABLE IF EXISTS diet_order;
CREATE TABLE diet_order
(
    id BIGINT PRIMARY KEY, --id
    tenant_id BIGINT, --商户id
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店id
    order_number VARCHAR(50), --订单号
    order_type TINYINT, --订单类型，1-扫码点餐，2-饿了么订单，3-美团订单
    order_status TINYINT, --订单状态，1-未生效订单，2-未处理订单，3-退单中订单，4-已处理订单，5-无效订单，6-已完订单
    pay_status TINYINT, --订单付款状态，1-未付款，2-已付款
    refund_status TINYINT, --订单退款状态，1-未申请退款，2-用户申请退款，3-店铺拒绝退款，4-客服仲裁中，5-退款失败，6-退款成功
    total_amount DECIMAL(11, 3), --总金额
    discount_amount DECIMAL(11, 3), --优惠金额
    payable_amount DECIMAL(11, 3), --应付金额
    paid_amount DECIMAL(11, 3), --实付金额
    paid_type TINYINT, --支付类型，1-微信支付，2-支付宝支付
    remark VARCHAR(100), --备注
    delivery_address VARCHAR(255), --配送地址
    delivery_longitude VARCHAR(20), --配送地址经度
    delivery_latitude VARCHAR(20), --配送地址纬度
    deliver_time DATETIME, --预计送达时间
    active_time DATETIME, --订单生效时间
    deliver_fee DECIMAL(11, 3), --配送费
    telephone_number VARCHAR(20), --联系电话
    day_serial_number VARCHAR(20), --当日流水号
    consignee VARCHAR(20), --收货人姓名
    invoiced TINYINT, --是否需要发票
    invoice_type VARCHAR(10), --发票类型，personal-个人，company-企业
    invoice VARCHAR(30), --发票抬头
    vip_id BIGINT, --会员ID
    local_id VARCHAR(50), --本地ID
    local_created_time DATETIME, --本地创建时间
    local_updated_time DATETIME, --本地最后更新时间
    job_id VARCHAR(100), --失效订单任务ID
    trigger_id VARCHAR(100), --失效订单任务触发器ID
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS diet_order_group;
CREATE TABLE diet_order_group
(
    id BIGINT PRIMARY KEY, --id
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店ID
    diet_order_id BIGINT, --diet_order.id
    `name` VARCHAR(20), --组名
    `type` VARCHAR(20), --normal-正常的菜品，extra-配送费等，discount-赠品
    local_id VARCHAR(50), --本地ID
    local_diet_order_id VARCHAR(50), --本地订单ID，local_diet_order.local_id
    local_created_time VARCHAR(255), --本地创建时间
    local_updated_time VARCHAR(255), --本地最后更新时间
    created_time VARCHAR(255), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除'
);

CREATE TABLE diet_order_detail
(
    id BIGINT PRIMARY KEY, --id
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店ID
    diet_order_id BIGINT, --订单ID
    diet_order_group_id BIGINT, --订单组ID，diet_order_group.id
    goods_type TINYINT, --商品类型，1-普通商品，2-套餐，3-套餐明细
    goods_id BIGINT, --菜品ID
    goods_name VARCHAR(20), --菜品名称
    goods_specification_id BIGINT, --菜品规格ID
    goods_specification_name VARCHAR(20), --菜品名称
    package_id BIGINT, --套餐ID
    package_group_id BIGINT, --套餐组ID
    package_group_name VARCHAR(20), --套餐组名称
    category_id BIGINT, --商品分类id
    category_name VARCHAR(20), --商品分类名称
    price DECIMAL(11, 3), --单价
    attribute_increase DECIMAL(11, 3), --口味加价
    quantity DECIMAL(11, 3), --数量
    total_amount DECIMAL(11, 3), --总金额
    discount_amount DECIMAL(11, 3), --优惠金额
    payable_amount DECIMAL(11, 3), --应付金额
    local_id VARCHAR(50), --本地ID
    local_diet_order_id VARCHAR(50), --本地订单id，diet_order_id.local_id
    local_diet_order_group_id VARCHAR(50), --本地订单组id，diet_order_group.local_id
    local_created_time VARCHAR(20), --本地创建时间
    local_updated_time VARCHAR(20), --本地最后更新时间
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS diet_order_detail_goods_attribute;
CREATE TABLE diet_order_detail_goods_attribute
(
    id BIGINT PRIMARY KEY, --主键id
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店ID
    diet_order_id BIGINT, --订单详情ID
    diet_order_group_id BIGINT, --订单组ID，diet_order_group.id
    diet_order_detail_id BIGINT, --订单明细ID
    goods_attribute_group_id BIGINT, --goods_attribute_group.id
    goods_attribute_group_name VARCHAR(20), --口味组名称
    goods_attribute_id BIGINT, --goods_attribute.id
    goods_attribute_name VARCHAR(20), --口味名称
    price DECIMAL(11, 3), --口味加价
    local_id VARCHAR(50), --本地ID
    local_diet_order_id VARCHAR(50), --本地订单id，diet_order_id.local_id
    local_diet_order_group_id VARCHAR(50), --本地订单组id，diet_order_group.local_id
    local_diet_order_detail_id VARCHAR(50), --本地订单详情id, diet_order_detail.local_id
    local_created_time VARCHAR(20), --本地创建时间
    local_updated_time VARCHAR(20), --本地最后更新时间
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS diet_order_activity;
CREATE TABLE diet_order_activity
(
    id BIGINT PRIMARY KEY, --id
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店ID
    diet_order_id BIGINT, --diet_order.id
    activity_id BIGINT, --活动id，activity.id
    activity_name VARCHAR(20), --活动名称，activity.name
    activity_type TINYINT, --活动类型，activity.type
    amount DECIMAL(11, 3), --金额
    local_id VARCHAR(50), --本地ID
    local_diet_order_id VARCHAR(50), --本地订单ID，local_diet_order.local_id
    local_created_time VARCHAR(20), --本地创建时间
    local_updated_time VARCHAR(20), --本地最后更新时间
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS diet_order_payment;
CREATE TABLE diet_order_payment
(
    id BIGINT PRIMARY KEY,  --id
    tenant_id BIGINT, --商户ID
    tenant_code VARCHAR(20), --商户编码
    branch_id BIGINT, --门店ID
    diet_order_id BIGINT, --diet_order.id
    payment_id BIGINT, --支付方式id
    payment_code VARCHAR(10), --支付方式编码
    payment_name VARCHAR(10), --支付方式名称
    paid_amount DECIMAL(11, 3), --支付的金额
    occurrence_time VARCHAR(20), --发生时间
    extra_info VARCHAR(255), --扩展信息，用于保存储值支付的兑换比例，微信支付、支付宝支付的支付场景
    local_id VARCHAR(50), --本地ID
    local_diet_order_id VARCHAR(50), --本地订单ID，local_diet_order.local_id
    local_created_time VARCHAR(20), --本地创建时间
    local_updated_time VARCHAR(20), --本地最后更新时间
    created_time VARCHAR(20), --创建时间
    created_user_id BIGINT, --创建人id
    updated_time VARCHAR(20), --最后更新时间
    updated_user_id BIGINT, --最后更新人id
    updated_remark VARCHAR(255), --最后更新备注
    deleted_time VARCHAR(20), --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00
    deleted TINYINT --是否删除，0-未删除，1-已删除
);

DROP TABLE IF EXISTS mqtt_info;
CREATE TABLE mqtt_info
(
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, --ID
    end_point TEXT NOT NULL, --end point
    client_id TEXT NOT NULL, --client id
    user_name TEXT NOT NULL, --user name
    password TEXT NOT NULL, --password
    topic TEXT NOT NULL, --topic
    created_time TEXT NOT NULL, --创建时间
    created_user_id INTEGER NOT NULL, --创建人id
    updated_time TEXT NOT NULL, --最后更新时间
    updated_user_id INTEGER NOT NULL, --最后更新人id
    updated_remark TEXT NOT NULL, --最后更新备注
    deleted_time TEXT DEFAULT '1970-01-01 00:00:00', --删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted INTEGER DEFAULT 0 --是否删除，0-未删除，1-已删除'
);