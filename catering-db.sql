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
    eleme_account_type TINYINT NOT NULL COMMENT '1-连锁账号，2-独立账号',
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
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店id',
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
    local_id VARCHAR(50) COMMENT '本地ID',
    local_create_time DATETIME COMMENT '本地创建时间',
    local_last_update_time DATETIME COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
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
	  name VARCHAR(20) NOT NULL COMMENT '组名',
	  type VARCHAR(20) NOT NULL COMMENT 'normal-正常的菜品，extra-配送费等，discount-赠品',
	  local_id VARCHAR(50) COMMENT '本地ID',
	  local_diet_order_id VARCHAR(50) COMMENT '本地订单ID，local_diet_order.local_id',
	  local_create_time DATETIME COMMENT '本地创建时间',
	  local_last_update_time DATETIME COMMENT '本地最后更新时间',
	  create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
	  create_user_id BIGINT NOT NULL COMMENT '创建人id',
	  last_update_time DATETIME DEFAULT now() ON UPDATE now() NOT NULL COMMENT '最后更新时间',
	  last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
	  last_update_remark VARCHAR(255) COMMENT '最后更新备注',
	  deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '餐厅订单';

DROP TABLE IF EXISTS diet_order_detail;
CREATE TABLE diet_order_detail(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
	  tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT '订单ID',
    diet_order_group_id BIGINT NOT NULL COMMENT '订单组ID，diet_order_group.id',
    goods_id BIGINT NOT NULL COMMENT '菜品ID',
    goods_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    goods_specification_id BIGINT COMMENT '菜品规格ID',
    goods_specification_name VARCHAR(20) NOT NULL COMMENT '菜品名称',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    flavor_increase DECIMAL(11, 3) COMMENT '口味加价',
    quantity INT NOT NULL COMMENT '数量',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_amount DECIMAL(11, 3) NOT NULL COMMENT '优惠金额',
    payable_amount DECIMAL(11, 3) NOT NULL COMMENT '应付金额',
    local_id VARCHAR(50) COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) COMMENT '本地订单id，diet_order_id.local_id',
    local_diet_order_group_id VARCHAR(50) COMMENT '本地订单组id，diet_order_group.local_id',
    local_create_time DATETIME COMMENT '本地创建时间',
    local_last_update_time DATETIME COMMENT '本地最后更新时间',
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
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    diet_order_id BIGINT NOT NULL COMMENT '订单详情ID',
    diet_order_group_id BIGINT NOT NULL COMMENT '订单组ID，diet_order_group.id',
    diet_order_detail_id BIGINT NOT NULL COMMENT '订单明细ID',
    goods_flavor_group_id BIGINT NOT NULL COMMENT 'goods_flavor_group.id',
    goods_flavor_group_name VARCHAR(20) NOT NULL COMMENT '口味组名称',
    goods_flavor_id BIGINT NOT NULL COMMENT 'goods_flavor.id',
    goods_flavor_name VARCHAR(20) NOT NULL COMMENT '口味名称',
    price DECIMAL(11, 3) COMMENT '口味加价',
    local_id VARCHAR(50) COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) COMMENT '本地订单id，diet_order_id.local_id',
    local_diet_order_group_id VARCHAR(50) COMMENT '本地订单组id，diet_order_group.local_id',
    local_diet_order_detail_id VARCHAR(50) COMMENT '本地订单详情id, diet_order_detail.local_id',
    local_create_time DATETIME COMMENT '本地创建时间',
    local_last_update_time DATETIME COMMENT '本地最后更新时间',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
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
    local_id VARCHAR(50) COMMENT '本地ID',
    local_diet_order_id VARCHAR(50) COMMENT '本地订单ID，local_diet_order.local_id',
    local_create_time DATETIME COMMENT '本地创建时间',
    local_last_update_time DATETIME COMMENT '本地最后更新时间',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME DEFAULT now() ON UPDATE now() NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '订单参与的活动';

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

DROP TABLE IF EXISTS eleme_refund_order_message;
CREATE TABLE eleme_refund_order_message
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    refund_status VARCHAR(20) COMMENT '退单状态，noRefund-未申请退单，applied-用户申请退单，rejected-店铺拒绝退单，arbitrating-客服仲裁中，failed-退单失败，successful-退单成功',
    reason VARCHAR(255) COMMENT '退单操作原因描述',
    shop_id BIGINT COMMENT '店铺id',
    refund_type VARCHAR(10) COMMENT '退单类型，normal-全额退款，part-部分退款',
    total_price DECIMAL(11, 3) COMMENT '退款金额',
    update_time DATETIME COMMENT '消息发送时间戳',
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
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编码',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    eleme_order_id BIGINT NOT NULL COMMENT 'eleme_order.id',
    order_id VARCHAR(50) COMMENT '饿了么系统订单ID',
    eleme_refund_order_message_id BIGINT NOT NULL COMMENT '饿了么退单消息ID',
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
    state VARCHAR(20) COMMENT '运单主状态，tobeAssignedMerchant-待分配（物流系统已生成运单，待分配配送商），tobeAssignedCourier-待分配（配送系统已接单，待分配配送员），tobeFetched-待取餐（已分配给配送员，配送员未取餐）,delivering-配送中（配送员已取餐，正在配送），completed-配送成功（配送员配送完成），cancelled-配送取消（商家可以重新发起配送），exception-配送异常，arrived-已到店(配送员已到店)，selfDelivery-商家自行配送，noMoreDelivery-商家不再配送，reject-物流拒单',
    sub_state VARCHAR(20) COMMENT '运单子状态，merchantReason-商家取消，carrierReason-配送商取消，userReason-用户取消，systemReason-物流系统取消，merchantCallLateError-呼叫配送晚，merchantFoodError-餐厅出餐问题，merchantInterruptDeliveryError-商户中断配送，userNotAnswerError-用户不接电话，userReturnOrderError-用户退单，userAddressError-用户地址错误，deliveryOutOfService-超出服务范围，carrierRemarkExceptionError-骑手标记异常，systemMarkedError-系统自动标记异常--订单超过3小时未送达，otherError-其他异常，deliveryTimeout-配送超时，系统标记异常，onlinePayError-只支持在线订单，consumerLocationTooFarError-超出服务范围，merchantPushTooLateError-请求配送过晚, 无法呼叫，systemError-系统异常',
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

DROP TABLE IF EXISTS goods;
CREATE TABLE goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    `type` TINYINT NOT NULL COMMENT '产品类型，1-普通商品，2-套餐',
    category_id BIGINT NOT NULL COMMENT '商品分类',
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
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '菜品名称',
    price DECIMAL(11, 3) COMMENT '口味加价',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS goods_flavor_group;
CREATE TABLE goods_flavor_group
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
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS goods_flavor;
CREATE TABLE goods_flavor
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    goods_id BIGINT NOT NULL COMMENT '产品ID',
    goods_flavor_group_id BIGINT NOT NULL COMMENT '产品ID',
    `name` VARCHAR(20) NOT NULL COMMENT '口味组名称',
    price DECIMAL(11, 3) COMMENT '口味加价',
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
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    name VARCHAR(20) NOT NULL COMMENT '活动名称',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    type TINYINT NOT NULL COMMENT '活动类型，1-买A赠B活动，2-整单满减活动，3-特价商品活动',
    status TINYINT NOT NULL COMMENT '活动状态，1-未执行，2-执行中，3-已终止，4-已过期',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS buy_give_activity;
CREATE TABLE buy_give_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
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
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS full_reduction_activity;
CREATE TABLE full_reduction_activity
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    tenant_code VARCHAR(20) NOT NULL COMMENT '商户编号',
    branch_id BIGINT NOT NULL COMMENT '门店ID',
    activity_id BIGINT NOT NULL COMMENT '活动ID',
    total_amount DECIMAL(11, 3) NOT NULL COMMENT '总金额',
    discount_type TINYINT NOT NULL COMMENT '优惠方式，1-按金额优惠，2-按折扣率优惠',
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
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    create_user_id BIGINT(20) NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '最后更新时间',
    last_update_user_id BIGINT(20) NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT(4) DEFAULT '0' NOT NULL COMMENT '是否删除，0-为删除，1-已删除'
);


DROP TABLE IF EXISTS mei_tuan_order_item;
CREATE TABLE mei_tuan_order_item
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
);

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
);

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
);

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
);

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
);

DROP TABLE IF EXISTS mei_tuan_order_cancel_message;
CREATE TABLE act_order_charge_by_poi
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    mei_order_id BIGINT NOT NULL COMMENT 'mei_tuan_order.id',
    developer_id BIGINT NOT NULL COMMENT 'ERP厂商入驻新美大餐饮平台得到的唯一身份表示',
    e_poi_id VARCHAR(100) NOT NULL COMMENT 'erp方门店id 最大长度100',
    `sign` VARCHAR(100) NOT NULL COMMENT '数字签名',
    order_id BIGINT NOT NULL COMMENT '美团订单ID',
    reason_code VARCHAR(20) COMMENT '取消原因类型',
    reason VARCHAR(100) COMMENT '取消原因描述',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建人id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
);

DROP TABLE IF EXISTS package_group;
CREATE TABLE package_group
(
    id BIGINT PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    tenant_id BIGINT NOT NULL COMMENT '商户id',
    branch_id BIGINT NOT NULL COMMENT '门店id',
    package_id BIGINT NOT NULL COMMENT '套餐id',
    group_type TINYINT NOT NULL COMMENT '套餐组类型，1-可选组，2-必选组',
    optional_quantity INT COMMENT '可选数量',
    create_time DATETIME DEFAULT now() NOT NULL COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '套餐组';

DROP TABLE IF EXISTS package_group_goods;
CREATE TABLE package_group_goods
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    package_group_id BIGINT NOT NULL COMMENT 'package_group.id',
    goods_id BIGINT NOT NULL COMMENT 'goods.id',
    quantity INT NOT NULL COMMENT '商品数量'
) COMMENT = '套餐组产品';

DROP TABLE IF EXISTS data_handle_history;
CREATE TABLE data_handle_history (
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
    vip_code VARCHAR(20) NOT NULL COMMENT '会员编号',
    vip_name VARCHAR(20) NOT NULL COMMENT '会员姓名',
    birthday DATE COMMENT '会员生日',
    phone_number VARCHAR(20) NOT NULL COMMENT '手机号码',
    open_id VARCHAR(50) COMMENT '微信open id',
    main_open_id VARCHAR(50) COMMENT '微信主账号open id',
    alipay_user_id VARCHAR(50) COMMENT '支付宝user id',
    create_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    create_user_id BIGINT NOT NULL COMMENT '创建用户id',
    last_update_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    last_update_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    last_update_remark VARCHAR(255) COMMENT '最后更新备注',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
);

CREATE TABLE can_not_delete_reason
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
) COMMENT '不能删除的原因';