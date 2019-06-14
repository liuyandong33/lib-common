DROP TABLE IF EXISTS merge_user_branch;
CREATE TABLE merge_user_branch
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 0 时有意义，默认值为1970-01-01 00:00:00',
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
    vip_group_id BIGINT NOT NULL COMMENT '会员分组ID',
    business_times VARCHAR(255) NOT NULL COMMENT '营业时间',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    job_id VARCHAR(100) NOT NULL COMMENT '失效订单任务ID',
    trigger_id VARCHAR(100) NOT NULL COMMENT '失效订单任务触发器ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    package_id BIGINT NOT NULL COMMENT '套餐ID',
    package_group_id BIGINT NOT NULL COMMENT '套餐组ID',
    package_group_name VARCHAR(20) NOT NULL COMMENT '套餐组名称',
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
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    activity_type TINYINT NOT NULL COMMENT '活动类型，activity.type',
    amount DECIMAL(11, 3) NOT NULL COMMENT '金额',
    local_id VARCHAR(50) NOT NULL COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) NOT NULL COMMENT '本地订单ID，local_diet_order.local_id',
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单参与的活动';

DROP TABLE IF EXISTS diet_order_payment;
CREATE TABLE diet_order_payment
(
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
    local_created_time DATETIME NOT NULL COMMENT '本地创建时间',
    local_updated_time DATETIME NOT NULL COMMENT '本地最后更新时间',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单支付方式';

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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    auditor_user_id BIGINT NOT NULL COMMENT '审核人',
    audit_time DATETIME NOT NULL COMMENT '审核时间',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    `status` TINYINT NOT NULL COMMENT '状态，1-未审核，2-已审核',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '营销活动';

DROP TABLE IF EXISTS activity_branch_r;
CREATE TABLE activity_branch_r
(
    activity_id BIGINT NOT NULL COMMENT '活动Id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    `name` VARCHAR(20) NOT NULL COMMENT '门店名称',
    description VARCHAR(50) NOT NULL COMMENT '分类描述',
    parent_id BIGINT NOT NULL COMMENT '上级分类id',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '商品分类表';

DROP TABLE IF EXISTS package_group;
CREATE TABLE package_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    package_id BIGINT NOT NULL COMMENT '套餐id',
    group_name VARCHAR(20) NOT NULL COMMENT '组名称',
    group_type TINYINT NOT NULL COMMENT '套餐组类型，1-可选组，2-必选组',
    optional_quantity INT NOT NULL COMMENT '可选数量',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '套餐组';

DROP TABLE IF EXISTS package_group_detail;
CREATE TABLE package_group_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    package_id BIGINT NOT NULL COMMENT '套餐id',
    package_group_id BIGINT NOT NULL COMMENT 'package_group.id',
    goods_id BIGINT NOT NULL COMMENT '商品id',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格id',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '商品数量',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '套餐组明细';


DROP TABLE IF EXISTS data_handle_history;
CREATE TABLE data_handle_history
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    signature VARCHAR(50) NOT NULL COMMENT '数据签名',
    data_type VARCHAR(20) NOT NULL COMMENT '数据类型',
    data_content TEXT NOT NULL COMMENT '数据内容',
    handle_time DATETIME NOT NULL DEFAULT NOW() COMMENT '处理时间',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '数据处理历史';

DROP TABLE IF EXISTS vip;
CREATE TABLE vip
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_code VARCHAR(20) NOT NULL COMMENT '会员编号',
    vip_name VARCHAR(20) NOT NULL COMMENT '会员姓名',
    birthday DATE NOT NULL COMMENT '会员生日',
    phone_number VARCHAR(20) NOT NULL COMMENT '手机号码',
    open_id VARCHAR(50) NOT NULL COMMENT '微信open id',
    main_open_id VARCHAR(50) NOT NULL COMMENT '微信主账号open id',
    alipay_user_id VARCHAR(50) NOT NULL COMMENT '支付宝user id',
    card_id VARCHAR(50) NOT NULL COMMENT '微信会员卡id',
    user_card_code VARCHAR(50) NOT NULL COMMENT '微信会员卡编号',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '会员表';

DROP TABLE IF EXISTS vip_type;
CREATE TABLE vip_type
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_group_id BIGINT NOT NULL COMMENT '会员分组ID',
    name VARCHAR(20) NOT NULL COMMENT '会员类型名称',
    discount_policy TINYINT NOT NULL COMMENT '优惠政策，1-无优惠，2-会员价，3-固定折扣',
    discount_rate DECIMAL(5, 2) NOT NULL COMMENT '折扣率',
    enable_bonus TINYINT NOT NULL COMMENT '是否启用积分',
    bonus_coefficient TINYINT NOT NULL COMMENT '积分系数，即多少钱积1积分',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '会员类型表';

DROP TABLE IF EXISTS vip_account;
CREATE TABLE vip_account
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_type_id BIGINT NOT NULL COMMENT '会员类型ID',
    vip_group_id BIGINT NOT NULL COMMENT '会员分组ID，如果会员共享类型为1-全部共享或2-全部独立，为0，如果会员3-分组共享，则为门店所在的会员分组ID',
    vip_id BIGINT NOT NULL COMMENT '会员ID',
    point DECIMAL(11, 3) NOT NULL COMMENT '会员积分',
    accumulative_point DECIMAL(11, 3) NOT NULL COMMENT '累计积分',
    balance DECIMAL(11, 3) NOT NULL COMMENT '余额',
    accumulative_recharge DECIMAL(11, 3) NOT NULL COMMENT '累计充值金额',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    operate_type TINYINT NOT NULL COMMENT '操作类型，1-删除，2-编辑，3-删除和编辑',
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
    created_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME DEFAULT NOW() ON UPDATE NOW() NOT NULL COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单配送状态';

DROP TABLE IF EXISTS eleme_callback_message;
CREATE TABLE eleme_callback_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    order_id VARCHAR(50) NOT NULL COMMENT '饿了么系统订单ID',
    request_id VARCHAR(50) NOT NULL COMMENT '请求ID',
    `type` TINYINT NOT NULL COMMENT '消息类型',
    app_id BIGINT NOT NULL COMMENT 'app id',
    message TEXT NOT NULL COMMENT 'message',
    shop_id BIGINT NOT NULL COMMENT 'shop id',
    `timestamp` DATETIME NOT NULL COMMENT 'timestamp',
    signature VARCHAR(50) NOT NULL COMMENT 'signature',
    user_id BIGINT NOT NULL COMMENT 'user id',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
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
    device_id VARCHAR(50) NOT NULL COMMENT '阿里云推送服务设备ID',
    type VARCHAR(10) NOT NULL COMMENT 'pos 类型，安卓-android，苹果-ios',
    version VARCHAR(10) NOT NULL COMMENT 'pos 版本号',
    online TINYINT NOT NULL COMMENT '是否在线，1-在线，0-不在线',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'POS信息表';

DROP TABLE IF EXISTS wei_xin_member_card;
CREATE TABLE wei_xin_member_card
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    app_id VARCHAR(50) NOT NULL COMMENT 'app id',
    card_id VARCHAR(50) NOT NULL COMMENT '微信会员卡id',
    url VARCHAR(255) NOT NULL COMMENT '投放二维码地址',
    show_qr_code_url VARCHAR(255) NOT NULL COMMENT '投放二维码显示地址',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '微信会员卡';

DROP TABLE IF EXISTS tenant_config;
CREATE TABLE tenant_config
(
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    name VARCHAR(50) NOT NULL COMMENT '序列名称',
    current_value INT(11) UNSIGNED NOT NULL COMMENT '当前值',
    max_value INT UNSIGNED NOT NULL COMMENT '最大值',
    PRIMARY KEY (tenant_id, tenant_code, name)
) COMMENT '商户配置';

DROP PROCEDURE IF EXISTS procedure_add_tenant_config;
DELIMITER $$
CREATE PROCEDURE procedure_add_tenant_config(IN tid BIGINT, IN tcode VARCHAR(20), IN config_name VARCHAR(50), IN increment INT)
BEGIN
    DECLARE `count` INT;
    DECLARE `max_value` INT;
    SELECT COUNT(1) INTO `count` FROM tenant_config WHERE `name` = config_name AND tenant_id = tid AND tenant_code = tcode;
    IF `count` = 0 THEN
        CASE config_name
            WHEN 'vip_num' THEN SET `max_value` = 10000;
            WHEN 'goods_num' THEN SET `max_value` = 20000;
        END CASE;
        INSERT INTO tenant_config(tenant_id, tenant_code, `name`, current_value, `max_value`) VALUES (tid, tcode, config_name, increment, `max_value`);
    ELSE
        UPDATE tenant_config SET current_value = current_value + increment WHERE `name` = config_name AND tenant_id = tid AND tenant_code = tcode;
    END IF;
    SELECT * FROM tenant_config WHERE `name` = config_name AND tenant_id = tid AND tenant_code = tcode;
END$$
DELIMITER ;

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
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
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
CREATE PROCEDURE procedure_deducting_vip_point(IN _tenant_id BIGINT, IN _vip_id BIGINT, IN _vip_account_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET point = point - _point WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
        SELECT point FROM vip_account WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
    END$$

DELIMITER ;

#扣减会员余额存储过程
DROP PROCEDURE IF EXISTS procedure_deducting_vip_balance;
DELIMITER $$
CREATE PROCEDURE procedure_deducting_vip_balance(IN _tenant_id BIGINT, IN _vip_id BIGINT, IN _vip_account_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET balance = balance - _balance WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
        SELECT balance FROM vip_account WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
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

#增加会员积分存储过程
DROP PROCEDURE IF EXISTS procedure_add_vip_point;
DELIMITER $$
CREATE PROCEDURE procedure_add_vip_point(IN _tenant_id BIGINT, IN _vip_id BIGINT, IN _vip_account_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET point = point + _point WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
        SELECT point FROM vip_account WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
    END$$

DELIMITER ;

#增加会员余额存储过程
DROP PROCEDURE IF EXISTS procedure_add_vip_balance;
DELIMITER $$
CREATE PROCEDURE procedure_add_vip_balance(IN _tenant_id BIGINT, IN _vip_id BIGINT, IN _vip_account_id BIGINT, IN _point DECIMAL(11, 3))
    BEGIN
        UPDATE vip_account SET balance = balance + _balance WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
        SELECT balance FROM vip_account WHERE tenant_id = _tenant_id AND vip_id = _vip_id AND id = _vip_account_id AND deleted = 0;
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '支付方式表';

DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '券名称',
    type TINYINT NOT NULL COMMENT '1-折扣券，2-代金券',
    face_value DECIMAL(11, 3) NOT NULL COMMENT '代金券面值',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS vip_point_history;
CREATE TABLE vip_point_history
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL  COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    vip_id BIGINT NOT NULL COMMENT '会员ID',
    `type` TINYINT NOT NULL COMMENT '类型，1-消费积分，2-消费赠送积分',
    change_point DECIMAL(11, 3) NOT NULL COMMENT '变更积分',
    remaining_point DECIMAL(11, 3) NOT NULL COMMENT '剩余积分',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '会员积分历史';

DROP TABLE IF EXISTS vip_group;
CREATE TABLE vip_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    name VARCHAR(20) NOT NULL COMMENT '分组名称',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS vip_group_branch_r;
CREATE TABLE vip_group_branch_r
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS distribution_center;
CREATE TABLE distribution_center
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    `code` VARCHAR(20) NOT NULL COMMENT '配送中心编码',
    `name` VARCHAR(20) NOT NULL COMMENT '配送中心名称',
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
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '配送中心';

#连续执行两条sql语句的存储过程。
DROP PROCEDURE IF EXISTS procedure_execute_sql_2;
DELIMITER $$
CREATE PROCEDURE procedure_execute_sql_2(IN sql1 VARCHAR(10240), IN sql2 VARCHAR(10240))
    BEGIN
	      SET @sql1 = sql1;
	      SET @sql2 = sql2;
	      PREPARE sql1_statement FROM @sql1;
	      PREPARE sql2_statement FROM @sql2;
        EXECUTE sql1_statement;
        EXECUTE sql2_statement;
    END$$

DELIMITER ;

DROP TABLE IF EXISTS require_goods_order;
CREATE TABLE require_goods_order
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    distribution_center_id BIGINT NOT NULL COMMENT '配送中心ID',
    order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    originator_user_id BIGINT NOT NULL COMMENT '制单人',
    auditor_user_id BIGINT NOT NULL COMMENT '审核人',
    audit_time DATETIME NOT NULL COMMENT '审核时间',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    `status` TINYINT NOT NULL COMMENT '状态，1-未审核，2-已审核',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '要货单';

DROP TABLE IF EXISTS require_goods_order_detail;
CREATE TABLE require_goods_order_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    require_goods_order_id BIGINT NOT NULL COMMENT '要货单ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    unit_id BIGINT NOT NULL COMMENT '商品单位ID',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '进货数量',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '要货单明细';

DROP TABLE IF EXISTS offline_pay_record;
CREATE TABLE offline_pay_record
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    user_id BIGINT NOT NULL COMMENT 'user id',
    paid_scene TINYINT NOT NULL COMMENT '支付场景，1-微信付款码支付，2-微信公众号支付，3-微信网页支付，4-微信APP支付，5-微信H5支付，6-微信小程序支付，7-支付宝手机网站支付，8-支付宝电脑网站支付支付，9-支付宝APP支付，10-支付宝当面付',
    channel_type TINYINT NOT NULL COMMENT '通道类型，1-微信支付，2-支付宝支付，3-京东支付',
    trade_no VARCHAR(64) NOT NULL COMMENT '支付平台订单号',
    out_trade_no VARCHAR(64) NOT NULL COMMENT '外部订单号',
    refund_no VARCHAR(64) NOT NULL COMMENT '支付平台退款单号',
    out_refund_no VARCHAR(64) NOT NULL COMMENT '退款单号',
    total_amount INT NOT NULL COMMENT '支付金额，单位为分',
    auth_code VARCHAR(50) NOT NULL COMMENT '支付码',
    paid_status TINYINT NOT NULL COMMENT '支付状态，1-支付成功，2-支付中，3-支付失败',
    refund_status TINYINT NOT NULL COMMENT '1-未申请退款，2-申请退款，3-退款成功，4-退款失败',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '线下支付记录';

DROP TABLE IF EXISTS offline_pay_log;
CREATE TABLE offline_pay_log
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    offline_pay_record_id BIGINT NOT NULL COMMENT 'offline_pay_record.id',
    type TINYINT NOT NULL COMMENT '日志类型，1-支付，2-查询，3-退款，4-支付回调，5-退款回调',
    channel_result TEXT NOT NULL COMMENT '支付通道返回结果',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '线下支付日志';

DROP TABLE IF EXISTS wei_xin_menu;
CREATE TABLE wei_xin_menu
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    parent_id BIGINT NOT NULL COMMENT '父菜单id  0表示一级菜单',
    `name` VARCHAR(50) NOT NULL COMMENT '菜单名称',
    `type` VARCHAR(50) NOT NULL COMMENT '菜单类型，click，view，scancode_push，scancode_waitmsg，pic_sysphoto，pic_photo_or_album，pic_weixin，location_select，media_id，view_limited，miniprogram',
    message_content VARCHAR(1000) NOT NULL COMMENT '文本消息内容',
    media_id VARCHAR(50) NOT NULL COMMENT '永久素材media_id',
    url VARCHAR(1000) DEFAULT NULL COMMENT '链接url',
    page_path VARCHAR(50) NOT NULL COMMENT '小程序路径',
    mini_program_app_id VARCHAR(50) DEFAULT NULL COMMENT '小程序app id',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '微信菜单';

DROP TABLE IF EXISTS menu;
CREATE TABLE menu
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    `code` VARCHAR(50) NOT NULL COMMENT '菜牌编号',
    `name` VARCHAR(50) NOT NULL COMMENT '菜牌名称',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    `status` TINYINT NOT NULL COMMENT '菜牌状态，1-正常，2-停用',
    effective_scope TINYINT NOT NULL COMMENT '生效范围，1-线上，2-线下，3-线上线下',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '菜牌';

DROP TABLE IF EXISTS menu_detail;
CREATE TABLE menu_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    menu_id BIGINT NOT NULL COMMENT '菜牌ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    goods_unit_id BIGINT NOT NULL COMMENT '商品单位ID',
    price DECIMAL(11, 3) NOT NULL COMMENT '售价',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '菜牌明细';

DROP TABLE IF EXISTS menu_branch_r;
CREATE TABLE menu_branch_r
(
    menu_id BIGINT NOT NULL COMMENT '活动ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    PRIMARY KEY(menu_id, tenant_id, tenant_code, branch_id)
);

DROP TABLE IF EXISTS branch_table;
CREATE TABLE branch_table
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    table_area_id BIGINT NOT NULL COMMENT '桌台区域ID',
    code VARCHAR(20) NOT NULL COMMENT '桌台编号',
    name VARCHAR(20) NOT NULL COMMENT '桌台名称',
    status TINYINT NOT NULL COMMENT '状态，1-启用，2-禁用',
    dinners_number INT NOT NULL COMMENT '就餐人数',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '桌台';

DROP TABLE IF EXISTS table_area;
CREATE TABLE table_area
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '桌台区域名称',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '桌台区域';

DROP TABLE IF EXISTS flash_sale_activity;
CREATE TABLE flash_sale_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '秒杀活动名称',
    status TINYINT NOT NULL COMMENT '活动状态，1-未终止，2-已终止',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    limited tinyint(4) NOT NULL COMMENT '是否限购，1-限购，0-不限购',
    limit_quantity DECIMAL(11,3) NOT NULL COMMENT '限购数量',
    before_show_time INT(11) NOT NULL COMMENT '生效前显示时间',
    time_unit TINYINT(4) NOT NULL COMMENT '时间单位，1-天，2-小时，3-分钟',
    goods_id BIGINT(20) NOT NULL COMMENT '商品ID',
    goods_name VARCHAR(50) NOT NULL COMMENT '商品名称',
    image_url VARCHAR(255) NOT NULL COMMENT '商品图片地址',
    original_price DECIMAL(11,3) NOT NULL COMMENT '原价',
    flash_sale_price DECIMAL(11,3) NOT NULL COMMENT '秒杀价',
    flash_sale_stock DECIMAL(11,3) NOT NULL COMMENT '秒杀库存',
    description VARCHAR(255) NOT NULL COMMENT '活动说明',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '秒杀活动';

DROP TABLE IF EXISTS eleme_goods_mapping;
CREATE TABLE eleme_goods_mapping
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_goods_id BIGINT NOT NULL COMMENT '饿了么商品ID',
    eleme_spec_id BIGINT NOT NULL COMMENT '饿了么规格ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    goods_specification_id BIGINT NOT NULL COMMENT '商品规格ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '饿了么商品映射';

DROP TABLE IF EXISTS vip_point_book;
CREATE TABLE vip_point_book
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    vip_group_id BIGINT NOT NULL COMMENT '会员分组ID',
    vip_id BIGINT NOT NULL COMMENT '会员ID',
    type TINYINT NOT NULL COMMENT '1-消费赠送积分，2-积分扣减，3-注册赠送积分，4-会员生日赠送积分',
    change_amount DECIMAL(11, 3) NOT NULL COMMENT '变动数量',
    point_balance DECIMAL(11, 5) NOT NULL COMMENT '积分余额',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '会员积分记录';

DROP TABLE IF EXISTS diet_order_delivery_record;
CREATE TABLE diet_order_delivery_record
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT 'diet_order.id',
    state VARCHAR(50) NOT NULL COMMENT 'tobeAssignedMerchant-待分配（物流系统已生成运单，待分配配送商），tobeAssignedCourier-待分配（配送系统已接单，待分配配送员），tobeFetched-待取餐（已分配给配送员，配送员未取餐），delivering-配送中（配送员已取餐，正在配送），completed-配送成功（配送员配送完成），cancelled-配送取消（商家可以重新发起配送），exception-配送异常，arrived-已到店(配送员已到店)，selfDelivery-商家自行配送，noMoreDelivery-商家不再配送，reject-物流拒单',
    sub_state VARCHAR(50) NOT NULL COMMENT 'merchantReason-商家取消，carrierReason-配送商取消，userReason-用户取消，systemReason-物流系统取消，merchantCallLateError-呼叫配送晚，merchantFoodError-餐厅出餐问题，merchantInterruptDeliveryError-商户中断配送，userNotAnswerError-用户不接电话，userReturnOrderError-用户退单，userAddressError-用户地址错误，deliveryOutOfService-超出服务范围，carrierRemarkExceptionError-骑手标记异常，systemMarkedError-系统自动标记异常--订单超过3小时未送达，otherError-其他异常，deliveryTimeout-配送超时，系统标记异常，onlinePayError-只支持在线订单，consumerLocationTooFarError-超出服务范围，merchantPushTooLateError-请求配送过晚无法呼叫，systemError-系统异常，noSubstate-无配送子状态',
    deliver_name VARCHAR(20) NOT NULL COMMENT '配送员姓名',
    deliver_phone VARCHAR(20) NOT NULL COMMENT '配送员手机号',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME DEFAULT NOW() ON UPDATE NOW() NOT NULL COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单配送状态';