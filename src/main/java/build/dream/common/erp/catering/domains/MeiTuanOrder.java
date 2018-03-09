package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MeiTuanOrder extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 门店编码
     */
    private String branchCode;
    /**
     * 美团订单ID
     */
    private BigInteger orderId;
    /**
     * 美团订单展示Id
     */
    private BigInteger orderIdView;
    /**
     * 订单备注
     */
    private String caution;
    /**
     * 城市Id
     */
    private BigInteger cityId;
    /**
     * 订单创建时间
     */
    private Date ctime;
    /**
     * 订单更新时间
     */
    private Date utime;
    /**
     * 门店当天订单流水号
     */
    private String daySeq;
    /**
     * 用户预计送达时间，“立即送达”时为0
     */
    private Date deliveryTime;
    /**
     * 三方的门店Id
     */
    private String ePoiId;
    /**
     * 是否需要发票，0-不需要， 1-需要
     */
    private boolean hasInvoiced;
    /**
     * 发票抬头
     */
    private String invoiceTitle;
    /**
     * 发票税号
     */
    private String taxpayerId;
    /**
     * 用户是否收藏此门店
     */
    private boolean isFavorites;
    /**
     * 用户是否第一次在此门店点餐
     */
    private boolean isPoiFirstOrder;
    /**
     * 是否第三方配送
     */
    private boolean isThirdShipping;
    /**
     * 订餐地址纬度
     */
    private String latitude;
    /**
     * 订餐地址经度
     */
    private String longitude;
    /**
     * 配送方式码
     */
    private Integer logisticsCode;
    /**
     * 订单原价
     */
    private BigDecimal originalPrice;
    /**
     * 支付类型，1：货到付款；2：在线支付
     */
    private Integer payType;
    /**
     * 取餐类型，0：普通取餐；1：到店取餐 该信息默认不推送，如有需求可联系开放平台工作人员开通
     */
    private Integer pickType;
    /**
     * 门店地址
     */
    private String poiAddress;
    /**
     * 门店名称
     */
    private String poiName;
    /**
     * 商家电话
     */
    private String poiPhone;
    /**
     * 收货人地址
     */
    private String recipientAddress;
    /**
     * 收货人姓名
     */
    private String recipientName;
    /**
     * 收货人电话
     */
    private String recipientPhone;
    /**
     * 配送员电话
     */
    private String shipperPhone;
    /**
     * 配送费
     */
    private String shippingFee;
    /**
     * 订单状态，1-用户已提交订单；2-可推送到App方平台也可推送到商家；4-商家已确认；6-已配送；8-已完成；9-已取消
     */
    private Integer status;
    /**
     * 订单总价
     */
    private BigDecimal total;
    /**
     * 菜品份数
     */
    private Integer quantity;
    /**
     * 餐厅平均送餐时间，单位为分钟
     */
    private BigDecimal avgSendTime;
    /**
     * 用餐人数（0：用户没有选择用餐人数；1-10：用户选择的用餐人数；-10：10人以上用餐；99：用户不需要餐具）
     */
    private Integer dinnersNumber;
    /**
     * 美团门店ID
     */
    private BigInteger poiId;

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getOrderIdView() {
        return orderIdView;
    }

    public void setOrderIdView(BigInteger orderIdView) {
        this.orderIdView = orderIdView;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public BigInteger getCityId() {
        return cityId;
    }

    public void setCityId(BigInteger cityId) {
        this.cityId = cityId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getDaySeq() {
        return daySeq;
    }

    public void setDaySeq(String daySeq) {
        this.daySeq = daySeq;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getePoiId() {
        return ePoiId;
    }

    public void setePoiId(String ePoiId) {
        this.ePoiId = ePoiId;
    }

    public boolean isHasInvoiced() {
        return hasInvoiced;
    }

    public void setHasInvoiced(boolean hasInvoiced) {
        this.hasInvoiced = hasInvoiced;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }

    public boolean isPoiFirstOrder() {
        return isPoiFirstOrder;
    }

    public void setPoiFirstOrder(boolean poiFirstOrder) {
        isPoiFirstOrder = poiFirstOrder;
    }

    public boolean isThirdShipping() {
        return isThirdShipping;
    }

    public void setThirdShipping(boolean thirdShipping) {
        isThirdShipping = thirdShipping;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(Integer logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPickType() {
        return pickType;
    }

    public void setPickType(Integer pickType) {
        this.pickType = pickType;
    }

    public String getPoiAddress() {
        return poiAddress;
    }

    public void setPoiAddress(String poiAddress) {
        this.poiAddress = poiAddress;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public String getPoiPhone() {
        return poiPhone;
    }

    public void setPoiPhone(String poiPhone) {
        this.poiPhone = poiPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAvgSendTime() {
        return avgSendTime;
    }

    public void setAvgSendTime(BigDecimal avgSendTime) {
        this.avgSendTime = avgSendTime;
    }

    public Integer getDinnersNumber() {
        return dinnersNumber;
    }

    public void setDinnersNumber(Integer dinnersNumber) {
        this.dinnersNumber = dinnersNumber;
    }

    public BigInteger getPoiId() {
        return poiId;
    }

    public void setPoiId(BigInteger poiId) {
        this.poiId = poiId;
    }
}
