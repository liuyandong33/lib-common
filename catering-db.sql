DROP TABLE IF EXISTS merge_user_branch;
CREATE TABLE merge_user_branch
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS branch;
CREATE TABLE branch
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `code` VARCHAR(20) NOT NULL COMMENT '门店编码',
    `name` VARCHAR(20) NOT NULL COMMENT '门店名称',
    `type` TINYINT NOT NULL COMMENT '1-总部，2-直营店，3-加盟店，4-配送中心',
    `status` TINYINT NOT NULL COMMENT '状态，1-启用，2-停用',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    shop_id BIGINT COMMENT '饿了么店铺ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

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

DROP TABLE IF EXISTS diet_order;
CREATE TABLE diet_order(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    order_number VARCHAR(50) NOT NULL COMMENT '订单号',
    order_type TINYINT NOT NULL COMMENT '订单类型，1-扫码点餐，2-饿了么订单，3-美团订单',
    order_status TINYINT NOT NULL COMMENT '订单状态，1-订单未生效，2-订单已生效',
    pay_status TINYINT NOT NULL COMMENT '订单付款状态，1-未付款，2-已付款',
    refund_status TINYINT NOT NULL COMMENT '订单退款状态，1-未申请退款，2-用户申请退款，3-店铺拒绝退款，4-退款失败，5-退款成功',
    total_amount DECIMAL(11, 3) COMMENT '总金额',
    discount_amount DECIMAL(11, 3) COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) COMMENT '应付金额',
    paid_amount DECIMAL(11, 3) COMMENT '实付金额',
    paid_type TINYINT COMMENT '支付类型，1-微信支付，2-支付宝支付，3-饿了么线上支付，4-美团线上支付',
    remark VARCHAR(100) COMMENT '备注',
    delivery_address VARCHAR(255) COMMENT '配送地址',
    delivery_longitude VARCHAR(20) COMMENT '配送地址经度',
    delivery_latitude VARCHAR(20) COMMENT '配送地址纬度',
    deliver_time DATETIME COMMENT '预计送达时间',
    active_time DATETIME COMMENT '订单生效时间',
    deliver_fee DECIMAL(11, 3) COMMENT '配送费',
    telephone_number VARCHAR(20) COMMENT '联系电话',
    day_serial_number VARCHAR(20) COMMENT '当日流水号',
    consignee VARCHAR(20) COMMENT '收货人姓名',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '餐厅订单';

DROP TABLE IF EXISTS diet_order_detail;
CREATE TABLE diet_order_detail(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    diet_order_id BIGINT NOT NULL COMMENT '订单ID',
    goods_id BIGINT NOT NULL COMMENT '菜品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    goods_specification_id BIGINT COMMENT '菜品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
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
) COMMENT '餐厅订单明细';

DROP TABLE IF EXISTS diet_order_detail_goods_flavor;
CREATE TABLE diet_order_detail_goods_flavor
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    diet_order_detail_id BIGINT NOT NULL COMMENT '订单明细ID',
    goods_flavor_group_name VARCHAR(20) NOT NULL COMMENT '口味组名称',
    goods_flavor_name VARCHAR(20) NOT NULL COMMENT '口味名称',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单口味';

DROP TABLE IF EXISTS eleme_order;
CREATE TABLE eleme_order
(
    id BIGINT(30) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    branch_code VARCHAR(20) NOT NULL COMMENT '门店编码',
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
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_group;
CREATE TABLE eleme_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT COMMENT 'eleme_order.id',
    `name` VARCHAR(20) COMMENT '分组名称',
    `type` VARCHAR(20) COMMENT '分组类型，normal-正常的菜品，extra-配送费等，discount-赠品',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_item;
CREATE TABLE eleme_item
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_group_id BIGINT COMMENT 'eleme group id',
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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_item_attribute;
CREATE TABLE eleme_item_attribute
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_item_id BIGINT COMMENT 'eleme item id',
    `name` VARCHAR(20) COMMENT '属性名称',
    `value` VARCHAR(20) COMMENT '属性值',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_item_new_spec;
CREATE TABLE eleme_item_new_spec
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_item_id BIGINT COMMENT 'eleme item id',
    `name` VARCHAR(20) COMMENT '规格名称',
    `value` VARCHAR(20) COMMENT '规格值',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_activity;
CREATE TABLE eleme_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT NOT NULL COMMENT '饿了么订单ID，eleme_order.id',
    eleme_activity_id BIGINT COMMENT '饿了么活动ID',
    `name` VARCHAR(20) COMMENT '活动名称',
    category_id INT COMMENT '活动类别',
    meaning VARCHAR(20) COMMENT '活动类别含义',
    amount DECIMAL(11, 3) COMMENT '金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_refund_order_message;
CREATE TABLE eleme_refund_order_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT COMMENT '饿了么订单ID，eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    refund_status VARCHAR(20) COMMENT '退单状态，noRefund-未申请退单，applied-用户申请退单，rejected-店铺拒绝退单，arbitrating-客服仲裁中，failed-退单失败，successful-退单成功',
    reason VARCHAR(255) COMMENT '退单操作原因描述',
    shop_id BIGINT COMMENT '店铺id',
    refund_type VARCHAR(10) COMMENT '退单类型，normal-全额退款，part-部分退款',
    total_price DECIMAL(11, 3) COMMENT '退款金额',
    update_time DATETIME COMMENT '消息发送时间戳',
    tenant_id BIGINT COMMENT '商户ID',
    branch_id BIGINT COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_refund_order_message_goods_item;
CREATE TABLE eleme_refund_order_message_goods_item
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_refund_order_message_id BIGINT NOT NULL COMMENT '饿了么退单消息ID',,
    `name` VARCHAR(20) COMMENT '商品名称',
    quantity INT COMMENT '商品数量',
    price DECIMAL(11, 3) COMMENT '商品数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_reminder_message;
CREATE TABLE eleme_reminder_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT COMMENT '饿了么订单ID，eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    shop_id BIGINT COMMENT '店铺id',
    reminder_id BIGINT COMMENT '饿了么系统催单id',
    user_id BIGINT COMMENT '发起催单的饿了么系统用户id',
    update_time DATETIME COMMENT '用户发起催单的时间戳',
    tenant_id BIGINT COMMENT '商户ID',
    branch_id BIGINT COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_order_state_change_message;
CREATE TABLE eleme_order_state_change_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT COMMENT '饿了么订单ID，eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    state VARCHAR(20) COMMENT '订单状态，pending-未生效订单，unprocessed-未处理订单，refunding-退单中订单，valid-已处理订单，invalid-无效订单，settled-已完订单',
    shop_id BIGINT COMMENT '店铺id',
    update_time DATETIME COMMENT '用户发起催单的时间戳',
    role TINYINT COMMENT '驱动状态发生变更的操作者角色，1-下单用户，2-饿了么系统，3-饿了么商户，4-饿了么客服，5-饿了么开放平台系统	，6-饿了么短信系统，7-饿了么无线打印机系统，8-饿了么风控系统',
    tenant_id BIGINT COMMENT '商户ID',
    branch_id BIGINT COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_delivery_order_state_change_message;
CREATE TABLE eleme_delivery_order_state_change_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    eleme_order_id BIGINT COMMENT '饿了么订单ID，eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    shop_id BIGINT COMMENT '店铺id',
    state VARCHAR(20) COMMENT '运单主状态',
    sub_state VARCHAR(20) COMMENT '运单子状态',
    `name` VARCHAR(20) COMMENT '配送员名称',
    phone VARCHAR(20) COMMENT '配送员电话',
    update_time DATETIME COMMENT '消息发送时间',
    tenant_id BIGINT COMMENT '商户ID',
    branch_id BIGINT COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS goods_flavor_group;
CREATE TABLE goods_flavor_group
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '口味组名称',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS goods_flavor;
CREATE TABLE goods_flavor
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    goods_flavor_group_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '口味组名称',
    price DECIMAL(11, 3) COMMENT '口味加价',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);


DROP TABLE IF EXISTS goods;
CREATE TABLE goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS goods_specification;
CREATE TABLE goods_specification
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    price DECIMAL(11, 3) COMMENT '口味加价',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS activity;
CREATE TABLE activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '活动名称',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    type TINYINT NOT NULL COMMENT '活动类型',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS activity_buy_give;
CREATE TABLE activity_buy_give
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    buy_goods_id BIGINT NOT NULL COMMENT '购买产品id',
    buy_amount INT NOT NULL COMMENT '购买数量',
    give_goods_id BIGINT NOT NULL COMMENT '赠送产品ID',
    give_amount INT NOT NULL COMMENT '赠送数量',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS activity_full_reduction;
CREATE TABLE activity_full_reduction
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_rate DECIMAL(5, 2) COMMENT '折扣率',
    discount_amount DECIMAL(11, 3) COMMENT '折扣金额',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP PROCEDURE IF EXISTS proc_find_all_activities;
CREATE PROCEDURE proc_find_all_activities()
BEGIN
SELECT * FROM activity_buy_give WHERE activity_id = 1 AND deleted = 0;
SELECT * FROM activity_full_reduction WHERE activity_id = 2 AND deleted = 0;
END;

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
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);