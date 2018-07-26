DROP TABLE IF EXISTS merge_user_branch;
CREATE TABLE merge_user_branch
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 0 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '用户与门店关联表';

DROP TABLE IF EXISTS branch;
CREATE TABLE branch
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    `code` VARCHAR(20) NOT NULL COMMENT '门店编码',
    `name` VARCHAR(20) NOT NULL COMMENT '门店名称',
    `type` TINYINT NOT NULL COMMENT '1-总部，2-直营店，3-加盟店，4-配送中心',
    `status` TINYINT NOT NULL COMMENT '状态，1-启用，2-停用',
    province_code VARCHAR(10) NOT NULL COMMENT '省编码',
    province_name VARCHAR(10) NOT NULL COMMENT '省名称',
    city_code VARCHAR(10) NOT NULL COMMENT '市编码',
    city_name VARCHAR(10) NOT NULL COMMENT '市名称',
    district_code VARCHAR(10) NOT NULL COMMENT '区编码',
    district_name VARCHAR(10) NOT NULL COMMENT '区名称',
    address VARCHAR(255) NOT NULL COMMENT '门店详细地址',
    longitude VARCHAR(20) NOT NULL COMMENT '经度',
    latitude VARCHAR(20) NOT NULL COMMENT '纬度',
    linkman VARCHAR(20) NOT NULL COMMENT '联系人',
    contact_phone VARCHAR(20) NOT NULL COMMENT '联系电话',
    eleme_account_type TINYINT NOT NULL COMMENT '1-连锁账号，2-独立账号',
    shop_id BIGINT NOT NULL COMMENT '饿了么店铺ID',
    smart_restaurant_status TINYINT NOT NULL COMMENT '微餐厅状态，1-正常，2-禁用',
    app_auth_token VARCHAR(50) NOT NULL COMMENT '门店绑定的授权token',
    poi_id VARCHAR(10) NOT NULL COMMENT '美团门店ID',
    poi_name VARCHAR(20) NOT NULL COMMENT '美团门店名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '门店表';

DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence
(
    name VARCHAR(50) PRIMARY KEY NOT NULL COMMENT '序列名称',
    current_value INT(11) unsigned NOT NULL COMMENT '当前值',
    increment INT(11) unsigned DEFAULT '1' NOT NULL COMMENT '每次增长的值'
) COMMENT '序列';

DELIMITER $$
CREATE FUNCTION current_value(sequence_name VARCHAR(50)) RETURNS INT(11)
BEGIN
DECLARE `value` INT;
    SET `value` = 0;
    SELECT current_value INTO `value` FROM sequence WHERE `name` = sequence_name;
    IF `value` = 0 THEN
        SET `value` = 1;
        INSERT INTO sequence(`name`, current_value) VALUES(sequence_name, `value`);
    END IF;
    RETURN `value`;
END$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION next_value(sequence_name VARCHAR(50)) RETURNS INT(11)
BEGIN
UPDATE sequence SET current_value = current_value + increment WHERE `name` = sequence_name;
    RETURN current_value(sequence_name);
END$$
DELIMITER ;

DROP TABLE IF EXISTS diet_order;
CREATE TABLE diet_order
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    order_type TINYINT NOT NULL COMMENT '订单类型，1-扫码点餐，2-饿了么订单，3-美团订单',
    order_status TINYINT NOT NULL COMMENT '订单状态，1-未生效订单，2-未处理订单，3-退单中订单，4-已处理订单，5-无效订单，6-已完订单',
    pay_status TINYINT NOT NULL COMMENT '订单付款状态，1-未付款，2-已付款',
    refund_status TINYINT NOT NULL COMMENT '订单退款状态，1-未申请退款，2-用户申请退款，3-店铺拒绝退款，4-客服仲裁中，5-退款失败，6-退款成功',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    paid_amount DECIMAL(11, 3) NOT NULL COMMENT '实付金额',
    paid_type TINYINT NOT NULL COMMENT '支付类型，1-微信支付，2-支付宝支付',
    remark VARCHAR(100) NOT NULL COMMENT '备注',
    delivery_address VARCHAR(255) NOT NULL COMMENT '配送地址',
    delivery_longitude VARCHAR(20) NOT NULL COMMENT '配送地址经度',
    delivery_latitude VARCHAR(20) NOT NULL COMMENT '配送地址纬度',
    deliver_time DATETIME NOT NULL COMMENT '预计送达时间',
    active_time DATETIME NOT NULL COMMENT '订单生效时间',
    deliver_fee DECIMAL(11, 3) NOT NULL COMMENT '配送费',
    telephone_number VARCHAR(20) NOT NULL COMMENT '联系电话',
    day_serial_number VARCHAR(20) NOT NULL COMMENT '当日流水号',
    consignee VARCHAR(20) NOT NULL COMMENT '收货人姓名',
    invoiced TINYINT NOT NULL COMMENT '是否需要发票',
    invoice_type VARCHAR(10) NOT NULL COMMENT '发票类型，personal-个人，company-企业',
    invoice VARCHAR(30) NOT NULL COMMENT '发票抬头',
    vip_id BIGINT NOT NULL COMMENT '会员ID',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '餐厅订单';

DROP TABLE IF EXISTS diet_order_group;
CREATE TABLE diet_order_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    `name` VARCHAR(20) NOT NULL COMMENT '组名',
    `type` VARCHAR(20) NOT NULL COMMENT 'normal-正常的菜品，extra-配送费等，discount-赠品',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单ID，local_diet_order.local_id',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME DEFAULT NOW() ON UPDATE NOW() NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '餐厅分组表';

DROP TABLE IF EXISTS diet_order_detail;
CREATE TABLE diet_order_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT '订单ID',
    diet_order_group_id BIGINT NOT NULL COMMENT '订单组ID，diet_order_group.id',
    goods_type TINYINT NOT NULL COMMENT '商品类型，1-普通商品，2-套餐，3-套餐明细',
    goods_id BIGINT NOT NULL COMMENT '菜品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    goods_specification_id BIGINT NOT NULL COMMENT '菜品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    package_code VARCHAR(50) NOT NULL COMMENT '套餐编码，标记为一个套餐内的商品',
    category_id BIGINT NOT NULL COMMENT '商品分类id',
    category_name VARCHAR(20) NOT NULL COMMENT '商品分类名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    attribute_increase DECIMAL(11, 3) NOT NULL COMMENT '口味加价',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '数量',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单id，diet_order_id.local_id',
    local_diet_order_group_id VARCHAR(50) NOT NULL COMMENT '本地订单组id，diet_order_group.local_id',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '餐厅订单明细';

DROP TABLE IF EXISTS diet_order_detail_goods_attribute;
CREATE TABLE diet_order_detail_goods_attribute
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT '订单详情ID',
    diet_order_group_id BIGINT NOT NULL COMMENT '订单组ID，diet_order_group.id',
    diet_order_detail_id BIGINT NOT NULL COMMENT '订单明细ID',
    goods_attribute_group_id BIGINT NOT NULL COMMENT 'goods_attribute_group.id',
    goods_attribute_group_name VARCHAR(20) NOT NULL COMMENT '口味组名称',
    goods_attribute_id BIGINT NOT NULL COMMENT 'goods_attribute.id',
    goods_attribute_name VARCHAR(20) NOT NULL COMMENT '口味名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '口味加价',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单id，diet_order_id.local_id',
    local_diet_order_group_id VARCHAR(50) NOT NULL COMMENT '本地订单组id，diet_order_group.local_id',
    local_diet_order_detail_id VARCHAR(50) NOT NULL COMMENT '本地订单详情id, diet_order_detail.local_id',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单口味';

DROP TABLE IF EXISTS diet_order_activity;
CREATE TABLE diet_order_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    activity_id BIGINT NOT NULL COMMENT '活动id，activity.id',
    activity_name VARCHAR(20) NOT NULL COMMENT '活动名称，activity.name',
    activity_type TINYINT NOT NULL COMMENT '活动名称，activity.type',
    amount DECIMAL(11, 3) NOT NULL COMMENT '金额',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单ID，local_diet_order.local_id',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME DEFAULT NOW() ON UPDATE NOW() NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单参与的活动';

DROP TABLE IF EXISTS diet_order_payment;
CREATE TABLE diet_order_payment (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    payment_id BIGINT NOT NULL COMMENT '支付方式id',
    payment_code VARCHAR(10) NOT NULL COMMENT '支付方式编码',
    payment_name VARCHAR(10) NOT NULL COMMENT '支付方式名称',
    paid_amount DECIMAL(11, 3) NOT NULL COMMENT '支付的金额',
    occurrence_time DATETIME NOT NULL COMMENT '发生时间',
    extra_info VARCHAR(255) NOT NULL COMMENT '扩展信息，用于保存储值支付的兑换比例，微信支付、支付宝支付的支付场景',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单ID，local_diet_order.local_id',
    local_create_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_last_update_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单支付方式';

DROP TABLE IF EXISTS eleme_order;
CREATE TABLE eleme_order
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    address VARCHAR(100) COMMENT '顾客送餐地址',
    created_at DATETIME COMMENT '下单时间',
    active_at DATETIME COMMENT '订单生效时间，即支付时间，只有支付完成后才会推送订单，只有货到付款的订单生效时间等于下单时间',
    deliver_fee DECIMAL(11, 3) COMMENT '配送费',
    vip_delivery_fee_discount DECIMAL(11, 3) COMMENT '会员减配送费',
    deliver_time DATETIME COMMENT '预计送达时间',
    description VARCHAR(100) COMMENT '订单备注',
    invoice VARCHAR(50) COMMENT '发票抬头',
    book TINYINT COMMENT '是否预定单',
    online_paid TINYINT COMMENT '是否在线支付',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    phone_list VARCHAR(100) COMMENT '顾客联系电话，匿名用户下单，返回保护小号',
    shop_id BIGINT COMMENT '店铺ID',
    open_id VARCHAR(50) COMMENT '店铺绑定的外部ID',
    shop_name VARCHAR(50) COMMENT '店铺名称',
    day_sn INT COMMENT '店铺当日流水号',
    `status` VARCHAR(20) COMMENT '订单状态，pending-未生效订单，unprocessed-未处理订单，refunding-退单中订单，valid-已处理订单，invalid-无效订单，settled-已完订单',
    refund_status VARCHAR(20) COMMENT '退单状态，noRefund-未申请退单，applied-用户申请退单，rejected-店铺拒绝退单，arbitrating-客服仲裁中，failed-退单失败，successful-退单成功',
    user_id BIGINT COMMENT '下单用户ID',
    total_price DECIMAL(11, 3) COMMENT '订单总价，用户实际支付的金额，单位：元',
    original_price DECIMAL(11, 3) COMMENT '订单原始价格，订单优惠前的价格，即商品总价加上配送费和餐盒费，单位：元',
    consignee VARCHAR(20) COMMENT '订单收货人姓名',
    delivery_geo VARCHAR(50) COMMENT '订单收货地址经纬度(高德地图坐标系)',
    delivery_poi_address VARCHAR(100) COMMENT '送餐地址',
    invoiced TINYINT COMMENT '顾客是否需要发票',
    income DECIMAL(11, 3) COMMENT '店铺实收，店铺实际本单收入，订单总额扣除服务费、商户补贴金额',
    service_rate DECIMAL(11, 3) COMMENT '饿了么服务费率',
    service_fee DECIMAL (11, 3) COMMENT '饿了么服务费',
    hongbao DECIMAL(11, 3) COMMENT '订单中红包金额',
    package_fee DECIMAL(11, 3) COMMENT '餐盒费',
    activity_total DECIMAL(11, 3) COMMENT '订单活动总额',
    shop_part DECIMAL(11, 3) COMMENT '店铺承担活动费用',
    eleme_part DECIMAL(11, 3) COMMENT '饿了么承担活动费用',
    downgraded TINYINT COMMENT '降级标识，true为已降级，false为未降级。 平台为尽可能促成交易，会在一部分字段未生成的时候（如活动补贴），将订单生成。 如果需要完整的订单的订单信息，需要事后在降级标记为false时再进行读取。 当此字段为降级标识true的时候会影响本单收入的金额值计算不准确，请开发者务必注意。',
    secret_phone_expire_time DATETIME COMMENT '保护小号失效时间，当用户匿名下单,保护小号有失效时间',
    invoice_type VARCHAR(20) COMMENT '发票类型，personal-个人，company-企业',
    taxpayer_id VARCHAR(50) COMMENT '纳税人识别号',
    cold_box_fee DECIMAL(11, 3) COMMENT '冷链加价费',
    cancel_order_description VARCHAR(255) COMMENT '用户取消原因',
    cancel_order_created_at DATETIME COMMENT '用户申请取消时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单';

DROP TABLE IF EXISTS eleme_order_group;
CREATE TABLE eleme_order_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    `name` VARCHAR(20) COMMENT '分组名称',
    `type` VARCHAR(20) COMMENT '分组类型，normal-正常的菜品，extra-配送费等，discount-赠品',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单分组';

DROP TABLE IF EXISTS eleme_order_item;
CREATE TABLE eleme_order_item
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    eleme_order_group_id BIGINT NOT NULL COMMENT 'eleme group id',
    eleme_item_id BIGINT COMMENT '饿了么食物ID',
    sku_id BIGINT COMMENT '饿了么菜品规格ID',
    `name` VARCHAR(50) COMMENT '商品名称',
    category_id BIGINT COMMENT '订单中商品项的标识(注意，此处不是商品分类Id)',
    price DECIMAL(11, 3) COMMENT '单价',
    quantity INT COMMENT '数量',
    total DECIMAL(11, 3) COMMENT '总价',
    extend_code VARCHAR(50) COMMENT '商品扩展码',
    bar_code VARCHAR(50) COMMENT '商品条形码',
    weight DECIMAL(11, 3) COMMENT '商品重量(单位克)',
    user_price DECIMAL(11, 3) COMMENT '用户侧价格',
    shop_price DECIMAL(11, 3) COMMENT '商户侧价格',
    vfood_id BIGINT COMMENT '商品id',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单详情';

DROP TABLE IF EXISTS eleme_order_item_attribute;
CREATE TABLE eleme_order_item_attribute
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    eleme_order_item_id BIGINT COMMENT 'eleme_order_item.id',
    `name` VARCHAR(20) COMMENT '属性名称',
    `value` VARCHAR(20) COMMENT '属性值',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单属性';

DROP TABLE IF EXISTS eleme_order_item_new_spec;
CREATE TABLE eleme_order_item_new_spec
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    eleme_order_item_id BIGINT COMMENT 'eleme_order_item.id',
    `name` VARCHAR(20) COMMENT '规格名称',
    `value` VARCHAR(20) COMMENT '规格值',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单规格';

DROP TABLE IF EXISTS eleme_order_activity;
CREATE TABLE eleme_order_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    eleme_activity_id BIGINT COMMENT '饿了么活动ID',
    `name` VARCHAR(20) COMMENT '活动名称',
    category_id INT COMMENT '活动类别',
    eleme_part DECIMAL(11, 3) COMMENT '饿了么承担部分',
    restaurant_part DECIMAL(11, 3) COMMENT '商家承担部分',
    amount DECIMAL(11, 3) COMMENT '金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么订单活动';

DROP TABLE IF EXISTS goods;
CREATE TABLE goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    `type` TINYINT NOT NULL COMMENT '商品名称，1-普通商品，2-套餐',
    category_id BIGINT NOT NULL COMMENT '商品分类',
    image_url VARCHAR(200) NOT NULL COMMENT '商品图片url',
    stocked TINYINT NOT NULL COMMENT '是否管理库存',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品表';

DROP TABLE IF EXISTS goods_specification;
CREATE TABLE goods_specification
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '口味加价',
    stock DECIMAL(11, 3) NOT NULL COMMENT '库存数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品规格表';

DROP TABLE IF EXISTS goods_unit;
CREATE TABLE goods_unit
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '单位名称',
    proportion DECIMAL(11, 3) NOT NULL COMMENT '比例',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品单位表';

DROP TABLE IF EXISTS purchase_order;
CREATE TABLE purchase_order
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    order_number VARCHAR(50) NOT NULL COMMENT '单据编号',
    originator_user_id BIGINT NOT NULL COMMENT '制单人',
    reviewer_user_id BIGINT NOT NULL COMMENT '审核人',
    review_time DATETIME NOT NULL COMMENT '审核时间',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '进货单';

DROP TABLE IF EXISTS purchase_order_detail;
CREATE TABLE purchase_order_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    purchase_order_id BIGINT NOT NULL COMMENT '进货单ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    unit_id BIGINT NOT NULL COMMENT '商品单位ID',
    purchase_price DECIMAL(11, 3) NOT NULL COMMENT '进货价',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '进货数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '进货单详情';

DROP TABLE IF EXISTS goods_attribute_group;
CREATE TABLE goods_attribute_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '口味组名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品口味组';

DROP TABLE IF EXISTS goods_attribute;
CREATE TABLE goods_attribute
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    goods_attribute_group_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '口味组名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '口味加价',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品口味';

DROP TABLE IF EXISTS activity;
CREATE TABLE activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    name VARCHAR(20) NOT NULL COMMENT '活动名称',
    start_date DATE NOT NULL COMMENT '开始日期',
    start_time TIME NOT NULL COMMENT '开始时间',
    end_date DATE NOT NULL COMMENT '开始日期',
    end_time TIME NOT NULL COMMENT '结束时间',
    week_sign INT NOT NULL COMMENT '星期标记，素数原理',
    type TINYINT NOT NULL COMMENT '活动类型，1-买A赠B活动，2-整单满减活动，3-特价商品活动，4-支付促销',
    status TINYINT NOT NULL COMMENT '活动状态，1-未执行，2-执行中，3-已终止，4-已过期',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '营销活动';

DROP TABLE IF EXISTS activity_branch_r;
CREATE TABLE activity_branch_r
(
    activity_id BIGINT NOT NULL COMMENT '活动Id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    PRIMARY KEY(activity_id, tenant_id, branch_id)
);

DROP TABLE IF EXISTS buy_give_activity;
CREATE TABLE buy_give_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    buy_goods_id BIGINT NOT NULL COMMENT '购买商品id',
    buy_goods_specification_id BIGINT NOT NULL COMMENT '购买商品规格id',
    buy_quantity INT NOT NULL COMMENT '购买数量',
    give_goods_id BIGINT NOT NULL COMMENT '赠送商品ID',
    give_goods_specification_id BIGINT NOT NULL COMMENT '赠送商品规格id',
    give_quantity INT NOT NULL COMMENT '赠送数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '买A赠B活动';

DROP TABLE IF EXISTS full_reduction_activity;
CREATE TABLE full_reduction_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_type TINYINT NOT NULL COMMENT '优惠方式，1-按金额优惠，2-按折扣率优惠',
    discount_rate DECIMAL(5, 2) NOT NULL COMMENT '折扣率',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '折扣金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '整单满减活动';

DROP TABLE IF EXISTS payment_activity;
CREATE TABLE payment_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    paid_type TINYINT NOT NULL COMMENT '支付方式，1-微信支付，2-支付宝支付，3-现金支付',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_type TINYINT NOT NULL COMMENT '优惠方式，1-按金额优惠，2-按折扣率优惠',
    discount_rate DECIMAL(5, 2) NOT NULL COMMENT '折扣率',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '折扣金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '支付促销';

DROP TABLE IF EXISTS special_goods_activity;
CREATE TABLE special_goods_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    goods_id BIGINT NOT NULL COMMENT '商品id',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格id',
    discount_type TINYINT NOT NULL COMMENT '优惠方式，1-特价，2-折扣',
    special_price DECIMAL(11, 3) NOT NULL COMMENT '特价金额',
    discount_rate DECIMAL(5, 2) NOT NULL COMMENT '折扣率',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '特价商品活动';

DROP PROCEDURE IF EXISTS procedure_effective_activity;
DELIMITER $$
CREATE PROCEDURE procedure_effective_activity(IN tenant_id BIGINT, IN branch_id BIGINT)
    BEGIN
        SELECT
        activity.id AS activity_id,
        activity.tenant_id,
        activity.tenant_code,
        activity_branch_r.branch_id,
        activity.name,
        activity.start_date,
        activity.start_time,
        activity.end_date,
        activity.end_time,
        activity.type,
        activity.status,
        buy_give_activity.buy_goods_id AS goods_id,
        buy_goods.name AS goods_name,
        buy_give_activity.buy_goods_specification_id AS goods_specification_id,
        buy_goods_specification.name AS goods_specification_name,
        buy_goods_specification.price,
        buy_give_activity.buy_quantity,
        buy_give_activity.give_goods_id,
        give_goods.name AS give_goods_name,
        buy_give_activity.give_goods_specification_id,
        give_goods_specification.name AS give_goods_specification_name,
        give_goods_specification.price AS give_price,
        buy_give_activity.give_quantity,
        goods_category.id AS category_id,
        goods_category.name AS category_name,
        NULL AS total_amount,
        NULL AS discount_type,
        NULL AS discount_rate,
        NULL AS discount_amount,
        NULL AS special_price,
        NULL AS paid_type
        FROM activity
        INNER JOIN activity_branch_r ON activity_branch_r.activity_id = activity.id AND activity_branch_r.tenant_id = tenant_id AND activity_branch_r.branch_id = branch_id
        INNER JOIN buy_give_activity ON buy_give_activity.activity_id = activity.id
        INNER JOIN goods AS buy_goods ON buy_goods.id = buy_give_activity.buy_goods_id AND buy_goods.deleted = 0
        INNER JOIN goods_specification AS buy_goods_specification ON buy_goods_specification.id = buy_give_activity.buy_goods_specification_id AND buy_goods_specification.deleted = 0
        INNER JOIN goods AS give_goods ON give_goods.id = buy_give_activity.give_goods_id AND give_goods.deleted = 0
        INNER JOIN goods_specification AS give_goods_specification ON give_goods_specification.id = buy_give_activity.give_goods_specification_id AND give_goods_specification.deleted = 0
        INNER JOIN goods_category ON goods_category.id = give_goods.category_id AND goods_category.deleted = 0
        WHERE activity.deleted = 0
        AND activity.type = 1
        AND activity.start_date <= DATE(NOW())
        AND activity.end_date >= DATE(NOW())
        AND activity.start_time <= TIME(NOW())
        AND activity.end_time >= TIME(NOW())
        AND activity.status = 2
        AND activity.tenant_id = tenant_id
        AND (CASE (DAYOFWEEK(NOW())) WHEN 2 THEN week_sign % 2 = 0 WHEN 3 THEN week_sign % 3 = 0 WHEN 4 THEN week_sign % 5 = 0 WHEN 5 THEN week_sign % 7 = 0 WHEN 6 THEN week_sign % 11 = 0 WHEN 7 THEN week_sign % 13 = 0 WHEN 1 THEN week_sign % 17 = 0 END)
        UNION ALL
        SELECT
        activity.id AS activity_id,
        activity.tenant_id,
        activity.tenant_code,
        activity_branch_r.branch_id,
        activity.name,
        activity.start_date,
        activity.start_time,
        activity.end_date,
        activity.end_time,
        activity.type,
        activity.status,
        NULL AS goods_id,
        NULL AS goods_name,
        NULL AS goods_specification_id,
        NULL AS goods_specification_name,
        NULL AS price,
        NULL AS buy_quantity,
        NULL AS give_goods_id,
        NULL AS give_goods_name,
        NULL AS give_goods_specification_id,
        NULL AS give_goods_specification_name,
        NULL AS give_price,
        NULL AS give_quantity,
        NULL AS category_id,
        NULL AS category_name,
        full_reduction_activity.total_amount,
        full_reduction_activity.discount_type,
        full_reduction_activity.discount_rate,
        full_reduction_activity.discount_amount,
        NULL AS special_price,
        NULL AS paid_type
        FROM activity
        INNER JOIN activity_branch_r ON activity_branch_r.activity_id = activity.id AND activity_branch_r.tenant_id = tenant_id AND activity_branch_r.branch_id = branch_id
        INNER JOIN full_reduction_activity ON full_reduction_activity.activity_id = activity.id
        WHERE activity.deleted = 0
        AND activity.type = 2
        AND activity.start_date <= DATE(NOW())
        AND activity.end_date >= DATE(NOW())
        AND activity.start_time <= TIME(NOW())
        AND activity.end_time >= TIME(NOW())
        AND activity.status = 2
        AND activity.tenant_id = tenant_id
        AND (CASE (DAYOFWEEK(NOW())) WHEN 2 THEN week_sign % 2 = 0 WHEN 3 THEN week_sign % 3 = 0 WHEN 4 THEN week_sign % 5 = 0 WHEN 5 THEN week_sign % 7 = 0 WHEN 6 THEN week_sign % 11 = 0 WHEN 7 THEN week_sign % 13 = 0 WHEN 1 THEN week_sign % 17 = 0 END)
        UNION ALL
        SELECT
        activity.id AS activity_id,
        activity.tenant_id,
        activity.tenant_code,
        activity_branch_r.branch_id,
        activity.name,
        activity.start_date,
        activity.start_time,
        activity.end_date,
        activity.end_time,
        activity.type,
        activity.status,
        special_goods_activity.goods_id,
        goods.name AS goods_name,
        special_goods_activity.goods_specification_id,
        goods_specification.name AS goods_specification_name,
        NULL AS price,
        NULL AS buy_quantity,
        NULL AS give_goods_id,
        NULL AS give_goods_name,
        NULL AS give_goods_specification_id,
        NULL AS give_goods_specification_name,
        NULL AS give_price,
        NULL AS give_quantity,
        NULL AS category_id,
        NULL AS category_name,
        NULL AS total_amount,
        special_goods_activity.discount_type,
        special_goods_activity.discount_rate,
        NULL AS discount_amount,
        special_goods_activity.special_price,
        NULL AS paid_type
        FROM activity
        INNER JOIN activity_branch_r ON activity_branch_r.activity_id = activity.id AND activity_branch_r.tenant_id = tenant_id AND activity_branch_r.branch_id = branch_id
        INNER JOIN special_goods_activity ON special_goods_activity.activity_id = activity.id
        INNER JOIN goods ON goods.id = special_goods_activity.goods_id AND goods.deleted = 0
        INNER JOIN goods_specification ON goods_specification.id = special_goods_activity.goods_specification_id AND goods_specification.deleted = 0
        INNER JOIN goods_category ON goods_category.id = goods.id AND goods_category.deleted = 0
        WHERE activity.deleted = 0
        AND activity.type = 3
        AND activity.start_date <= DATE(NOW())
        AND activity.end_date >= DATE(NOW())
        AND activity.start_time <= TIME(NOW())
        AND activity.end_time >= TIME(NOW())
        AND activity.status = 2
        AND activity.tenant_id = tenant_id
        AND (CASE (DAYOFWEEK(NOW())) WHEN 2 THEN week_sign % 2 = 0 WHEN 3 THEN week_sign % 3 = 0 WHEN 4 THEN week_sign % 5 = 0 WHEN 5 THEN week_sign % 7 = 0 WHEN 6 THEN week_sign % 11 = 0 WHEN 7 THEN week_sign % 13 = 0 WHEN 1 THEN week_sign % 17 = 0 END)
        UNION ALL
        SELECT
        activity.id AS activity_id,
        activity.tenant_id,
        activity.tenant_code,
        activity_branch_r.branch_id,
        activity.name,
        activity.start_date,
        activity.start_time,
        activity.end_date,
        activity.end_time,
        activity.type,
        activity.status,
        NULL AS goods_id,
	      NULL AS goods_name,
        NULL AS goods_specification_id,
        NULL AS goods_specification_name,
        NULL AS price,
        NULL AS buy_quantity,
        NULL AS category_id,
        NULL AS category_name,
        NULL AS give_goods_id,
        NULL AS give_goods_name,
        NULL AS give_goods_specification_id,
        NULL AS give_goods_specification_name,
        NULL AS give_price,
        NULL AS give_quantity,
        payment_activity.total_amount,
        payment_activity.discount_type,
        payment_activity.discount_rate,
        payment_activity.discount_amount,
        NULL AS special_price,
        payment_activity.paid_type
        FROM activity
        INNER JOIN activity_branch_r ON activity_branch_r.activity_id = activity.id AND activity_branch_r.tenant_id = tenant_id AND activity_branch_r.branch_id = branch_id
        INNER JOIN payment_activity ON payment_activity.activity_id = activity.id
        WHERE activity.deleted = 0
        AND activity.type = 4
        AND activity.start_date <= DATE(NOW())
        AND activity.end_date >= DATE(NOW())
        AND activity.start_time <= TIME(NOW())
        AND activity.end_time >= TIME(NOW())
        AND activity.status = 2
        AND activity.tenant_id = tenant_id
        AND (CASE (DAYOFWEEK(NOW())) WHEN 2 THEN week_sign % 2 = 0 WHEN 3 THEN week_sign % 3 = 0 WHEN 4 THEN week_sign % 5 = 0 WHEN 5 THEN week_sign % 7 = 0 WHEN 6 THEN week_sign % 11 = 0 WHEN 7 THEN week_sign % 13 = 0 WHEN 1 THEN week_sign % 17 = 0 END);
    END$$

DELIMITER ;

DROP TABLE IF EXISTS goods_category;
CREATE TABLE goods_category
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    `name` VARCHAR(20) NOT NULL COMMENT '门店名称',
    description VARCHAR(50) NOT NULL COMMENT '分类描述',
    parent_id BIGINT NOT NULL COMMENT '上级分类id',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品分类表';

DROP TABLE IF EXISTS mei_tuan_order;
CREATE TABLE mei_tuan_order
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    branch_code VARCHAR(20) NOT NULL COMMENT '门店编码',
    order_id BIGINT COMMENT '美团订单ID',
    order_id_view BIGINT COMMENT '美团订单展示Id',
    caution VARCHAR(100) COMMENT '订单备注',
    city_id BIGINT COMMENT '城市Id',
    ctime DATETIME COMMENT '订单创建时间',
    utime DATETIME COMMENT '订单更新时间',
    day_seq VARCHAR(20) COMMENT '门店当天订单流水号',
    delivery_time DATETIME COMMENT '用户预计送达时间，“立即送达”时为0',
    e_poi_id VARCHAR(100) COMMENT '三方的门店Id',
    has_invoiced TINYINT COMMENT '是否需要发票，0-不需要， 1-需要',
    invoice_title VARCHAR(50) COMMENT '发票抬头',
    taxpayer_id VARCHAR(50) COMMENT '发票税号',
    is_favorites TINYINT COMMENT '用户是否收藏此门店',
    is_poi_first_order TINYINT COMMENT '用户是否第一次在此门店点餐',
    is_third_shipping TINYINT COMMENT '是否第三方配送',
    latitude VARCHAR(20) COMMENT '订餐地址纬度',
    longitude VARCHAR(20) COMMENT '订餐地址经度',
    logistics_code INT COMMENT '配送方式码',
    original_price DECIMAL(11, 3) COMMENT '订单原价',
    pay_type TINYINT COMMENT '支付类型，1：货到付款；2：在线支付',
    pick_type TINYINT COMMENT '取餐类型，0：普通取餐；1：到店取餐 该信息默认不推送，如有需求可联系开放平台工作人员开通',
    poi_address VARCHAR(100) COMMENT '门店地址',
    poi_name VARCHAR(20) COMMENT '门店名称',
    poi_phone VARCHAR(30) COMMENT '商家电话',
    recipient_address VARCHAR(100) COMMENT '收货人地址',
    recipient_name VARCHAR(20) COMMENT '收货人姓名',
    recipient_phone VARCHAR(30) COMMENT '收货人电话',
    shipper_phone VARCHAR(30) COMMENT '配送员电话',
    shipping_fee DECIMAL(11, 3) COMMENT '配送费',
    status TINYINT COMMENT '订单状态，1-用户已提交订单；2-可推送到App方平台也可推送到商家；4-商家已确认；6-已配送；8-已完成；9-已取消',
    total DECIMAL(11, 3) COMMENT '订单总价',
    quantity INT COMMENT '菜品份数',
    avg_send_time DECIMAL(11, 3) COMMENT '餐厅平均送餐时间，单位为分钟',
    dinners_number INT COMMENT '用餐人数（0：用户没有选择用餐人数；1-10：用户选择的用餐人数；-10：10人以上用餐；99：用户不需要餐具）',
    poi_id BIGINT COMMENT '美团门店ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT(4) DEFAULT '0' NOT NULL COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '美团订单';

DROP TABLE IF EXISTS mei_tuan_order_detail;
CREATE TABLE mei_tuan_order_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_tuan_order_id BIGINT NOT NULL COMMENT 'mei_tuan_order id',
    app_food_code VARCHAR(20) COMMENT 'erp方菜品id',
    box_num INT COMMENT '餐盒数量',
    box_price DECIMAL(11, 3) COMMENT '餐盒价格',
    food_name VARCHAR(20) COMMENT '菜品名称',
    price DECIMAL(11, 3) COMMENT '菜品价格',
    sku_id VARCHAR(20) COMMENT 'erp方菜品sku',
    quantity INT COMMENT '菜品份数',
    unit VARCHAR(10) COMMENT '菜品单位',
    food_discount DECIMAL(11, 3) COMMENT '菜品折扣',
    food_property VARCHAR(100) COMMENT '菜品属性',
    food_share_fee_charge_by_poi DECIMAL(11, 3) COMMENT '该订单中商家给美团的分成金额',
    cart_id INT COMMENT '商品所在的口袋，0为1号口袋，1为2号口袋，以此类推',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团订单详情';

DROP TABLE IF EXISTS mei_tuan_order_extra;
CREATE TABLE mei_tuan_order_extra
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_tuan_order_id BIGINT NOT NULL COMMENT 'mei_tuan_order id',
    mt_charge DECIMAL(11, 3) COMMENT '该活动中美团承担的费用',
    poi_charge DECIMAL(11, 3) COMMENT '该活动中商家承担的费用',
    reduce_fee DECIMAL(11, 3) COMMENT '活动优惠金额，是在原价基础上减免的金额。并非一定等于美团承担活动费用和商户承担费用的总和，如type=23，即买赠活动时，赠品的成本虽然由商家承担，但这部分不算在活动优惠金额内',
    remark VARCHAR(100) COMMENT '优惠说明',
    `type` TINYINT COMMENT '优惠活动类型（1-新用户立减；2-满减；4-套餐赠送；5-满赠；9-使用红包；11-提前下单减；16-满免配送费(即将废弃)；17-折扣商品；18-美团专送再减(即将废弃)；19-点评券；20-第二份半价；21-会员免配送费；22-门店新客立减；23-买赠；24-平台新用户立减；25-满减配送费；100-满返商家代金券；101-使用商家代金券；103-进店领券）',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团订单扩展信息';

DROP TABLE IF EXISTS mei_tuan_order_poi_receive_detail;
CREATE TABLE mei_tuan_order_poi_receive_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_tuan_order_id BIGINT NOT NULL COMMENT 'mei_tuan_order id',
    food_share_fee_charge_by_poi DECIMAL(11, 3) COMMENT '菜品分成',
    logistics_fee DECIMAL(11, 3) COMMENT '配送费',
    online_payment DECIMAL(11, 3) COMMENT '在线支付款',
    wm_poi_receive_cent DECIMAL(11, 3) COMMENT '商家应收款',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团订单配送信息';

DROP TABLE IF EXISTS act_order_charge_by_mt;
CREATE TABLE act_order_charge_by_mt
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_tuan_order_poi_receive_detail_id BIGINT NOT NULL COMMENT 'mei_tuan_order_poi_receive_detail id',
    `comment` VARCHAR(100) COMMENT '备注',
    fee_type_desc VARCHAR(100) COMMENT '明细费用类型描述',
    fee_type_id BIGINT COMMENT '明细费用类型Id',
    money_cent DECIMAL(11, 3) COMMENT '明细金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团美团端对账单';

DROP TABLE IF EXISTS act_order_charge_by_poi;
CREATE TABLE act_order_charge_by_poi
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_tuan_order_poi_receive_detail_id BIGINT NOT NULL COMMENT 'mei_tuan_order_poi_receive_detail id',
    `comment` VARCHAR(100) COMMENT '备注',
    fee_type_desc VARCHAR(100) COMMENT '明细费用类型描述',
    fee_type_id BIGINT COMMENT '明细费用类型Id',
    money_cent DECIMAL(11, 3) COMMENT '明细金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团店铺端队长单';

DROP TABLE IF EXISTS mei_tuan_order_cancel_message;
CREATE TABLE mei_tuan_order_cancel_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    developer_id BIGINT NOT NULL COMMENT 'ERP厂商入驻新美大餐饮平台得到的唯一身份表示',
    e_poi_id VARCHAR(100) NOT NULL COMMENT 'erp方门店id 最大长度100',
    `sign` VARCHAR(100) NOT NULL COMMENT '数字签名',
    order_id BIGINT NOT NULL COMMENT '美团订单ID',
    reason_code VARCHAR(20) NOT NULL COMMENT '取消原因类型',
    reason VARCHAR(100) NOT NULL COMMENT '取消原因描述',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团取消订单消息';

DROP TABLE IF EXISTS mei_tuan_order_refund_message;
CREATE TABLE mei_tuan_order_refund_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    developer_id BIGINT NOT NULL COMMENT 'ERP厂商入驻新美大餐饮平台得到的唯一身份表示',
    e_poi_id VARCHAR(100) NOT NULL COMMENT 'erp方门店id 最大长度100',
    `sign` VARCHAR(100) NOT NULL COMMENT '数字签名',
    order_id BIGINT NOT NULL COMMENT '美团订单ID',
    notify_type VARCHAR(20) NOT NULL COMMENT '退款消息类型',
    reason VARCHAR(100) NOT NULL COMMENT '退款理由',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '美团退款订单消息';

DROP TABLE IF EXISTS package_group;
CREATE TABLE package_group
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    package_id BIGINT NOT NULL COMMENT '套餐id',
    group_name VARCHAR(20) NOT NULL COMMENT '组名称',
    group_type TINYINT NOT NULL COMMENT '套餐组类型，1-可选组，2-必选组',
    optional_quantity INT NOT NULL COMMENT '可选数量',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '套餐组';

DROP TABLE IF EXISTS package_group_goods;
CREATE TABLE package_group_goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    package_group_id BIGINT NOT NULL COMMENT 'package_group.id',
    goods_id BIGINT NOT NULL COMMENT '商品id',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格id',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '商品数量',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '套餐组产品';

DROP TABLE IF EXISTS data_handle_history;
CREATE TABLE data_handle_history
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    signature VARCHAR(50) NOT NULL COMMENT '数据签名',
    data_type VARCHAR(20) NOT NULL COMMENT '数据类型',
    data_content TEXT NOT NULL COMMENT '数据内容',
    handle_time DATETIME NOT NULL DEFAULT NOW() COMMENT '处理时间'
) COMMENT = '数据处理历史';

DROP TABLE IF EXISTS vip;
CREATE TABLE vip
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_type_id BIGINT NOT NULL COMMENT '会员类型ID',
    vip_code VARCHAR(20) NOT NULL COMMENT '会员编号',
    vip_name VARCHAR(20) NOT NULL COMMENT '会员姓名',
    birthday DATE NOT NULL COMMENT '会员生日',
    phone_number VARCHAR(20) NOT NULL COMMENT '手机号码',
    open_id VARCHAR(50) NOT NULL COMMENT '微信open id',
    main_open_id VARCHAR(50) NOT NULL COMMENT '微信主账号open id',
    alipay_user_id VARCHAR(50) NOT NULL COMMENT '支付宝user id',
    card_id VARCHAR(50) NOT NULL COMMENT '微信会员卡id',
    user_card_code VARCHAR(50) NOT NULL COMMENT '微信会员卡编号',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '会员表';

DROP TABLE IF EXISTS vip_type;
CREATE TABLE vip_type
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '会员类型名称',
    discount_policy TINYINT NOT NULL COMMENT '优惠政策，1-无优惠，2-会员价，3-固定折扣',
    discount_rate DECIMAL(5, 2) NOT NULL COMMENT '折扣率',
    enable_bonus TINYINT NOT NULL COMMENT '是否启用积分',
    bonus_coefficient TINYINT NOT NULL COMMENT '积分系数，即多少钱积1积分',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '会员类型表';

DROP TABLE IF EXISTS vip_account;
CREATE TABLE vip_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_id BIGINT NOT NULL COMMENT '会员ID',
    point DECIMAL(11, 3) NOT NULL COMMENT '会员积分',
    accumulative_point DECIMAL(11, 3) NOT NULL COMMENT '累计积分',
    balance DECIMAL(11, 3) NOT NULL COMMENT '余额',
    accumulative_recharge DECIMAL(11, 3) NOT NULL COMMENT '累计充值金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '会员账户表';

DROP TABLE IF EXISTS can_not_operate_reason;
CREATE TABLE can_not_operate_reason
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
	  tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    table_id BIGINT NOT NULL COMMENT '表id',
    table_name VARCHAR(100) NOT NULL COMMENT '表名',
    cause_table_id BIGINT NOT NULL COMMENT '导致不能删除的表id',
    cause_table_name VARCHAR(100) NOT NULL COMMENT '导致不能删除的表名字',
    reason VARCHAR(255) NOT NULL COMMENT '原因'
) COMMENT '不能操作的原因';

DROP TABLE IF EXISTS diet_order_delivery_state;
CREATE TABLE diet_order_delivery_state
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    diet_order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    status TINYINT NOT NULL COMMENT '状态，1-配送系统已接单，20-已分配骑手，80-骑手已到店，2-配送中，3-已送达，5-系统拒单/配送异常',
    carrier_driver_name VARCHAR(20) NOT NULL COMMENT '蜂鸟配送员姓名',
    carrier_driver_phone VARCHAR(20) NOT NULL COMMENT '蜂鸟配送员电话',
    description VARCHAR(255) NOT NULL COMMENT '描述信息',
    station_name VARCHAR(20) NOT NULL COMMENT '配送站名字',
    station_tel VARCHAR(20) NOT NULL COMMENT '配送站电话',
    cancel_reason TINYINT NOT NULL COMMENT '订单取消原因. 1:用户取消, 2:商家取消',
    error_code VARCHAR(20) NOT NULL COMMENT '错误编码',
    address VARCHAR(255) NOT NULL COMMENT '定点次日达服务独有的字段: 微仓地址',
    longitude VARCHAR(20) NOT NULL COMMENT '定点次日达服务独有的字段: 微仓经度',
    latitude VARCHAR(20) NOT NULL COMMENT '定点次日达服务独有的字段: 微仓纬度',
    push_time DATETIME NOT NULL COMMENT '推送时间',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME DEFAULT now() ON UPDATE now() NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单配送状态';

DROP TABLE IF EXISTS eleme_callback_message;
CREATE TABLE eleme_callback_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    order_id VARCHAR(50) NOT NULL COMMENT '饿了么系统订单ID',
    request_id VARCHAR(50) NOT NULL COMMENT '请求ID',
    `type` TINYINT NOT NULL COMMENT '消息类型',
    app_id BIGINT NOT NULL COMMENT 'app id',
    message TEXT NOT NULL COMMENT 'message',
    shop_id BIGINT NOT NULL COMMENT 'shop id',
    `timestamp` DATETIME NOT NULL COMMENT 'timestamp',
    signature VARCHAR(50) NOT NULL COMMENT 'signature',
    user_id BIGINT NOT NULL COMMENT 'user id'
) COMMENT '饿了么回调消息';

DROP TABLE IF EXISTS pos;
CREATE TABLE pos
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    branch_code VARCHAR(20) NOT NULL COMMENT '门店编码',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    registration_id VARCHAR(50) NOT NULL COMMENT 'jpush 注册Id',
    type VARCHAR(10) NOT NULL COMMENT 'pos 类型，安卓-android，苹果-ios',
    version VARCHAR(10) NOT NULL COMMENT 'pos 版本号',
    online TINYINT NOT NULL COMMENT '是否在线，1-在线，0-不在线',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'POS信息表';

DROP TABLE IF EXISTS wei_xin_member_card;
CREATE TABLE wei_xin_member_card
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT(20) NOT NULL COMMENT '商户ID',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    card_id VARCHAR(50) NOT NULL COMMENT '微信会员卡id',
    url VARCHAR(255) NOT NULL COMMENT '投放二维码地址',
    show_qr_code_url VARCHAR(255) NOT NULL COMMENT '投放二维码显示地址',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT(20) NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT(20) NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT(4) DEFAULT '0' NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '微信会员卡';

DROP TABLE IF EXISTS tenant_config;
CREATE TABLE tenant_config
(
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    name VARCHAR(50) NOT NULL COMMENT '序列名称',
    current_value INT(11) UNSIGNED NOT NULL COMMENT '当前值',
    max_value INT UNSIGNED NOT NULL COMMENT '最大值',
    PRIMARY KEY (tenant_id, name)
) COMMENT '商户配置';

DROP PROCEDURE IF EXISTS add_tenant_config;
CREATE PROCEDURE add_tenant_config(IN tid BIGINT, IN config_name VARCHAR(50), IN increment INT)
BEGIN
    DECLARE count INT;
    DECLARE max_value INT;
    SELECT COUNT(1) INTO count FROM tenant_config WHERE name = config_name AND tenant_id = tid;
    IF count = 0 THEN
        CASE config_name
            WHEN 'vip_num' THEN SET max_value = 10000;
            WHEN 'goods_num' THEN SET max_value = 20000;
        END CASE;
        INSERT INTO tenant_config(tenant_id, name, current_value, max_value) VALUES (tid, config_name, increment, max_value);
    ELSE
        UPDATE tenant_config SET current_value = current_value + increment WHERE name = config_name AND tenant_config.tenant_id = tid;
    END IF;
    SELECT * FROM tenant_config WHERE name = config_name AND tenant_config.tenant_id = tid;
END;

DROP TABLE IF EXISTS sale;
CREATE TABLE sale
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    sale_code VARCHAR(50) NOT NULL COMMENT 'sale code',
    sale_time DATETIME NOT NULL COMMENT '销售时间',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    paid_amount DECIMAL(11, 3) NOT NULL COMMENT '实付金额',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '流水表';

DROP TABLE IF EXISTS sale_detail;
CREATE TABLE sale_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    sale_id BIGINT NOT NULL COMMENT 'sale.id',
    sale_time DATETIME NOT NULL COMMENT '销售时间',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    goods_id BIGINT NOT NULL COMMENT '菜品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    goods_specification_id BIGINT NOT NULL COMMENT '菜品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    category_id BIGINT NOT NULL COMMENT '商品分类id',
    category_name VARCHAR(20) NOT NULL COMMENT '商品分类名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    quantity INT NOT NULL COMMENT '数量',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    discount_share DECIMAL(11, 3) NOT NULL COMMENT '优惠分摊',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '流水详情表';

DROP TABLE IF EXISTS sale_payment;
CREATE TABLE sale_payment
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    sale_id BIGINT NOT NULL COMMENT 'sale.id',
    sale_time DATETIME NOT NULL COMMENT '销售时间',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    payment_id BIGINT NOT NULL COMMENT '支付方式id',
    payment_code VARCHAR(10) NOT NULL COMMENT '支付方式编码',
    payment_name VARCHAR(10) NOT NULL COMMENT '支付方式名称',
    paid_amount DECIMAL(11, 3) NOT NULL COMMENT '支付的金额',
    create_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '支付方式表';

#扣减商品库存存储过程
DROP PROCEDURE IF EXISTS procedure_deducting_goods_stock;
DELIMITER $$
CREATE PROCEDURE procedure_deducting_goods_stock(IN _goods_id BIGINT, IN _goods_specification_id BIGINT, IN quantity DECIMAL(11, 3))
    BEGIN
        UPDATE goods_specification SET stock = stock - quantity WHERE goods_id = _goods_id AND id = _goods_specification_id AND deleted = 0;
        SELECT stock FROM goods_specification WHERE goods_id = _goods_id AND id = _goods_specification_id AND deleted = 0;
    END$$

DELIMITER ;

#扣减会员积分存储过程
DROP PROCEDURE IF EXISTS procedure_deducting_vip_point;
DELIMITER $$
CREATE PROCEDURE procedure_deducting_vip_point(IN _tenant_id BIGINT, IN _branch_id BIGINT, IN _vip_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET point = point - _point WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
        SELECT point FROM vip_account WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
    END$$

DELIMITER ;

#扣减会员余额存储过程
DROP PROCEDURE IF EXISTS procedure_deducting_vip_balance;
DELIMITER $$
CREATE PROCEDURE procedure_deducting_vip_balance(IN _tenant_id BIGINT, IN _branch_id BIGINT, IN _vip_id BIGINT, IN _balance DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET balance = balance - _balance WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
        SELECT balance FROM vip_account WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
    END$$

DELIMITER ;


#恢复商品库存存储过程
DROP PROCEDURE IF EXISTS procedure_add_goods_stock;
DELIMITER $$
CREATE PROCEDURE procedure_add_goods_stock(IN _goods_id BIGINT, IN _goods_specification_id BIGINT, IN quantity DECIMAL(11, 3))
    BEGIN
        UPDATE goods_specification SET stock = stock + quantity WHERE goods_id = _goods_id AND id = _goods_specification_id AND deleted = 0;
        SELECT stock FROM goods_specification WHERE goods_id = _goods_id AND id = _goods_specification_id AND deleted = 0;
    END$$

DELIMITER ;

#恢复会员积分存储过程
DROP PROCEDURE IF EXISTS procedure_add_vip_point;
DELIMITER $$
CREATE PROCEDURE procedure_add_vip_point(IN _tenant_id BIGINT, IN _branch_id BIGINT, IN _vip_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET point = point + _point WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
        SELECT point FROM vip_account WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
    END$$

DELIMITER ;

#恢复会员余额存储过程
DROP PROCEDURE IF EXISTS procedure_add_vip_balance;
DELIMITER $$
CREATE PROCEDURE procedure_add_vip_balance(IN _tenant_id BIGINT, IN _branch_id BIGINT, IN _vip_id BIGINT, IN _balance DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET balance = balance + _balance WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
        SELECT balance FROM vip_account WHERE tenant_id = _tenant_id AND branch_id = _branch_id AND vip_id = _vip_id AND deleted = 0;
    END$$

DELIMITER ;

DROP TABLE IF EXISTS payment;
CREATE TABLE payment
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    `code` VARCHAR(10) NOT NULL COMMENT '支付方式编码',
    `name` VARCHAR(10) NOT NULL COMMENT '支付方式名称',
    `status` TINYINT NOT NULL COMMENT '状态，1-启用，2-禁用',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    delete_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '支付方式表';