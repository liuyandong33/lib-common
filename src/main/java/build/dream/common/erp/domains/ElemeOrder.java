package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeOrder extends BasicDomain {
    private BigInteger tenantId;
    private String tenantCode;
    private BigInteger branchId;
    private String branchCode;
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

    private BigDecimal coldBoxFee;

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
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
}
