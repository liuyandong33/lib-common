package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeOrder extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 顾客送餐地址
     */
    private String address;
    /**
     * 下单时间
     */
    private Date createdAt;
    /**
     * 订单生效时间，即支付时间，只有支付完成后才会推送订单，只有货到付款的订单生效时间等于下单时间
     */
    private Date activeAt;
    /**
     * 配送费
     */
    private BigDecimal deliverFee;
    /**
     * 会员减配送费
     */
    private BigDecimal vipDeliveryFeeDiscount;
    /**
     * 预计送达时间
     */
    private Date deliverTime;
    /**
     * 订单备注
     */
    private String description;
    /**
     * 发票抬头
     */
    private String invoice;
    /**
     * 是否预订单
     */
    private boolean book;
    /***
     * 是否在线支付
     */
    private boolean onlinePaid;
    /**
     * 饿了么系统订单Id
     */
    private String orderId;
    /**
     * 顾客联系电话
     */
    private String phoneList;
    /**
     * shopId
     */
    private BigInteger shopId;
    /**
     * 店铺绑定的外部ID
     */
    private String openId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺当日订单流水号
     */
    private int daySn;
    /**
     * 订单状态，pending-未生效订单，unprocessed-未处理订单，refunding-退单中订单，valid-已处理订单，invalid-无效订单，settled-已完订单
     */
    private String status;
    /**
     * 退单状态，noRefund-未申请退单，applied-用户申请退单，rejected-店铺拒绝退单，arbitrating-客服仲裁中，failed-退单失败，successful-退单成功
     */
    private String refundStatus;
    /**
     * 下单用户的Id
     */
    private int userId;
    /**
     * 订单总价，用户实际支付的金额，单位：元
     */
    private BigDecimal totalPrice;
    /**
     * 订单原始价格，订单优惠前的价格，即商品总价加上配送费和餐盒费，单位：元
     */
    private BigDecimal originalPrice;
    /**
     * 订单收货人姓名
     */
    private String consignee;
    /**
     * 订单收货地址经纬度(高德地图坐标系)
     */
    private String deliveryGeo;
    /**
     * 送餐地址
     */
    private String deliveryPoiAddress;
    /**
     * 顾客是否需要发票
     */
    private boolean invoiced;
    /**
     * 店铺实收
     */
    private BigDecimal income;
    /**
     * 饿了么服务费率
     */
    private BigDecimal serviceRate;
    /**
     * 饿了么服务费
     */
    private BigDecimal serviceFee;
    /**
     * 订单中红包金额
     */
    private BigDecimal hongbao;
    /**
     * 餐盒费
     */
    private BigDecimal packageFee;
    /**
     * 订单活动总额
     */
    private BigDecimal activityTotal;
    /**
     * 店铺承担活动费用
     */
    private BigDecimal shopPart;
    /**
     * 饿了么承担活动费用
     */
    private BigDecimal elemePart;
    /**
     * 降级标识
     */
    private boolean downgraded;
    /**
     * 保护小号失效时间
     */
    private Date secretPhoneExpireTime;
    /**
     * 发票类型，personal-个人，company-企业
     */
    private String invoiceType;
    /**
     * 纳税人识别号
     */
    private String taxpayerId;
    /**
     * 冷链加价费
     */
    private BigDecimal coldBoxFee;
    /**
     * 用户取消原因
     */
    private String cancelOrderDescription;
    /**
     * 用户申请取消时间
     */
    private Date cancelOrderCreatedAt;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Date activeAt) {
        this.activeAt = activeAt;
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }

    public BigDecimal getVipDeliveryFeeDiscount() {
        return vipDeliveryFeeDiscount;
    }

    public void setVipDeliveryFeeDiscount(BigDecimal vipDeliveryFeeDiscount) {
        this.vipDeliveryFeeDiscount = vipDeliveryFeeDiscount;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isOnlinePaid() {
        return onlinePaid;
    }

    public void setOnlinePaid(boolean onlinePaid) {
        this.onlinePaid = onlinePaid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(String phoneList) {
        this.phoneList = phoneList;
    }

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getDaySn() {
        return daySn;
    }

    public void setDaySn(int daySn) {
        this.daySn = daySn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliveryGeo() {
        return deliveryGeo;
    }

    public void setDeliveryGeo(String deliveryGeo) {
        this.deliveryGeo = deliveryGeo;
    }

    public String getDeliveryPoiAddress() {
        return deliveryPoiAddress;
    }

    public void setDeliveryPoiAddress(String deliveryPoiAddress) {
        this.deliveryPoiAddress = deliveryPoiAddress;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = serviceRate;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getHongbao() {
        return hongbao;
    }

    public void setHongbao(BigDecimal hongbao) {
        this.hongbao = hongbao;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public BigDecimal getActivityTotal() {
        return activityTotal;
    }

    public void setActivityTotal(BigDecimal activityTotal) {
        this.activityTotal = activityTotal;
    }

    public BigDecimal getShopPart() {
        return shopPart;
    }

    public void setShopPart(BigDecimal shopPart) {
        this.shopPart = shopPart;
    }

    public BigDecimal getElemePart() {
        return elemePart;
    }

    public void setElemePart(BigDecimal elemePart) {
        this.elemePart = elemePart;
    }

    public boolean isDowngraded() {
        return downgraded;
    }

    public void setDowngraded(boolean downgraded) {
        this.downgraded = downgraded;
    }

    public Date getSecretPhoneExpireTime() {
        return secretPhoneExpireTime;
    }

    public void setSecretPhoneExpireTime(Date secretPhoneExpireTime) {
        this.secretPhoneExpireTime = secretPhoneExpireTime;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public BigDecimal getColdBoxFee() {
        return coldBoxFee;
    }

    public void setColdBoxFee(BigDecimal coldBoxFee) {
        this.coldBoxFee = coldBoxFee;
    }

    public String getCancelOrderDescription() {
        return cancelOrderDescription;
    }

    public void setCancelOrderDescription(String cancelOrderDescription) {
        this.cancelOrderDescription = cancelOrderDescription;
    }

    public Date getCancelOrderCreatedAt() {
        return cancelOrderCreatedAt;
    }

    public void setCancelOrderCreatedAt(Date cancelOrderCreatedAt) {
        this.cancelOrderCreatedAt = cancelOrderCreatedAt;
    }

    public static class Builder {
        private final ElemeOrder instance = new ElemeOrder();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder createdAt(Date createdAt) {
            instance.setCreatedAt(createdAt);
            return this;
        }

        public Builder activeAt(Date activeAt) {
            instance.setActiveAt(activeAt);
            return this;
        }

        public Builder deliverFee(BigDecimal deliverFee) {
            instance.setDeliverFee(deliverFee);
            return this;
        }

        public Builder vipDeliveryFeeDiscount(BigDecimal vipDeliveryFeeDiscount) {
            instance.setVipDeliveryFeeDiscount(vipDeliveryFeeDiscount);
            return this;
        }

        public Builder deliverTime(Date deliverTime) {
            instance.setDeliverTime(deliverTime);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder invoice(String invoice) {
            instance.setInvoice(invoice);
            return this;
        }

        public Builder book(boolean book) {
            instance.setBook(book);
            return this;
        }

        public Builder onlinePaid(boolean onlinePaid) {
            instance.setOnlinePaid(onlinePaid);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder phoneList(String phoneList) {
            instance.setPhoneList(phoneList);
            return this;
        }

        public Builder shopId(BigInteger shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder openId(String openId) {
            instance.setOpenId(openId);
            return this;
        }

        public Builder shopName(String shopName) {
            instance.setShopName(shopName);
            return this;
        }

        public Builder daySn(int daySn) {
            instance.setDaySn(daySn);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder refundStatus(String refundStatus) {
            instance.setRefundStatus(refundStatus);
            return this;
        }

        public Builder userId(int userId) {
            instance.setUserId(userId);
            return this;
        }

        public Builder totalPrice(BigDecimal totalPrice) {
            instance.setTotalPrice(totalPrice);
            return this;
        }

        public Builder originalPrice(BigDecimal originalPrice) {
            instance.setOriginalPrice(originalPrice);
            return this;
        }

        public Builder consignee(String consignee) {
            instance.setConsignee(consignee);
            return this;
        }

        public Builder deliveryGeo(String deliveryGeo) {
            instance.setDeliveryGeo(deliveryGeo);
            return this;
        }

        public Builder deliveryPoiAddress(String deliveryPoiAddress) {
            instance.setDeliveryPoiAddress(deliveryPoiAddress);
            return this;
        }

        public Builder invoiced(boolean invoiced) {
            instance.setInvoiced(invoiced);
            return this;
        }

        public Builder income(BigDecimal income) {
            instance.setIncome(income);
            return this;
        }

        public Builder serviceRate(BigDecimal serviceRate) {
            instance.setServiceRate(serviceRate);
            return this;
        }

        public Builder serviceFee(BigDecimal serviceFee) {
            instance.setServiceFee(serviceFee);
            return this;
        }

        public Builder hongbao(BigDecimal hongbao) {
            instance.setHongbao(hongbao);
            return this;
        }

        public Builder packageFee(BigDecimal packageFee) {
            instance.setPackageFee(packageFee);
            return this;
        }

        public Builder activityTotal(BigDecimal activityTotal) {
            instance.setActivityTotal(activityTotal);
            return this;
        }

        public Builder shopPart(BigDecimal shopPart) {
            instance.setShopPart(shopPart);
            return this;
        }

        public Builder elemePart(BigDecimal elemePart) {
            instance.setElemePart(elemePart);
            return this;
        }

        public Builder downgraded(boolean downgraded) {
            instance.setDowngraded(downgraded);
            return this;
        }

        public Builder secretPhoneExpireTime(Date secretPhoneExpireTime) {
            instance.setSecretPhoneExpireTime(secretPhoneExpireTime);
            return this;
        }

        public Builder invoiceType(String invoiceType) {
            instance.setInvoiceType(invoiceType);
            return this;
        }

        public Builder taxpayerId(String taxpayerId) {
            instance.setTaxpayerId(taxpayerId);
            return this;
        }

        public Builder coldBoxFee(BigDecimal coldBoxFee) {
            instance.setColdBoxFee(coldBoxFee);
            return this;
        }

        public Builder cancelOrderDescription(String cancelOrderDescription) {
            instance.setCancelOrderDescription(cancelOrderDescription);
            return this;
        }

        public Builder cancelOrderCreatedAt(Date cancelOrderCreatedAt) {
            instance.setCancelOrderCreatedAt(cancelOrderCreatedAt);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ElemeOrder build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String ADDRESS = "address";
        public static final String CREATED_AT = "created_at";
        public static final String ACTIVE_AT = "active_at";
        public static final String DELIVER_FEE = "deliver_fee";
        public static final String VIP_DELIVERY_FEE_DISCOUNT = "vip_delivery_fee_discount";
        public static final String DELIVER_TIME = "deliver_time";
        public static final String DESCRIPTION = "description";
        public static final String INVOICE = "invoice";
        public static final String BOOK = "book";
        public static final String ONLINE_PAID = "online_paid";
        public static final String ORDER_ID = "order_id";
        public static final String PHONE_LIST = "phone_list";
        public static final String SHOP_ID = "shop_id";
        public static final String OPEN_ID = "open_id";
        public static final String SHOP_NAME = "shop_name";
        public static final String DAY_SN = "day_sn";
        public static final String STATUS = "status";
        public static final String REFUND_STATUS = "refund_status";
        public static final String USER_ID = "user_id";
        public static final String TOTAL_PRICE = "total_price";
        public static final String ORIGINAL_PRICE = "original_price";
        public static final String CONSIGNEE = "consignee";
        public static final String DELIVERY_GEO = "delivery_geo";
        public static final String DELIVERY_POI_ADDRESS = "delivery_poi_address";
        public static final String INVOICED = "invoiced";
        public static final String INCOME = "income";
        public static final String SERVICE_RATE = "service_rate";
        public static final String SERVICE_FEE = "service_fee";
        public static final String HONGBAO = "hongbao";
        public static final String PACKAGE_FEE = "package_fee";
        public static final String ACTIVITY_TOTAL = "activity_total";
        public static final String SHOP_PART = "shop_part";
        public static final String ELEME_PART = "eleme_part";
        public static final String DOWNGRADED = "downgraded";
        public static final String SECRET_PHONE_EXPIRE_TIME = "secret_phone_expire_time";
        public static final String INVOICE_TYPE = "invoice_type";
        public static final String TAXPAYER_ID = "taxpayer_id";
        public static final String COLD_BOX_FEE = "cold_box_fee";
        public static final String CANCEL_ORDER_DESCRIPTION = "cancel_order_description";
        public static final String CANCEL_ORDER_CREATED_AT = "cancel_order_created_at";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String ADDRESS = "address";
        public static final String CREATED_AT = "createdAt";
        public static final String ACTIVE_AT = "activeAt";
        public static final String DELIVER_FEE = "deliverFee";
        public static final String VIP_DELIVERY_FEE_DISCOUNT = "vipDeliveryFeeDiscount";
        public static final String DELIVER_TIME = "deliverTime";
        public static final String DESCRIPTION = "description";
        public static final String INVOICE = "invoice";
        public static final String BOOK = "book";
        public static final String ONLINE_PAID = "onlinePaid";
        public static final String ORDER_ID = "orderId";
        public static final String PHONE_LIST = "phoneList";
        public static final String SHOP_ID = "shopId";
        public static final String OPEN_ID = "openId";
        public static final String SHOP_NAME = "shopName";
        public static final String DAY_SN = "daySn";
        public static final String STATUS = "status";
        public static final String REFUND_STATUS = "refundStatus";
        public static final String USER_ID = "userId";
        public static final String TOTAL_PRICE = "totalPrice";
        public static final String ORIGINAL_PRICE = "originalPrice";
        public static final String CONSIGNEE = "consignee";
        public static final String DELIVERY_GEO = "deliveryGeo";
        public static final String DELIVERY_POI_ADDRESS = "deliveryPoiAddress";
        public static final String INVOICED = "invoiced";
        public static final String INCOME = "income";
        public static final String SERVICE_RATE = "serviceRate";
        public static final String SERVICE_FEE = "serviceFee";
        public static final String HONGBAO = "hongbao";
        public static final String PACKAGE_FEE = "packageFee";
        public static final String ACTIVITY_TOTAL = "activityTotal";
        public static final String SHOP_PART = "shopPart";
        public static final String ELEME_PART = "elemePart";
        public static final String DOWNGRADED = "downgraded";
        public static final String SECRET_PHONE_EXPIRE_TIME = "secretPhoneExpireTime";
        public static final String INVOICE_TYPE = "invoiceType";
        public static final String TAXPAYER_ID = "taxpayerId";
        public static final String COLD_BOX_FEE = "coldBoxFee";
        public static final String CANCEL_ORDER_DESCRIPTION = "cancelOrderDescription";
        public static final String CANCEL_ORDER_CREATED_AT = "cancelOrderCreatedAt";
    }
}
