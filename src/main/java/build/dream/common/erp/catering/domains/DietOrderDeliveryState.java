package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class DietOrderDeliveryState extends BasicDomain {
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
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 订单号
     */
    private String dietOrderNumber;
    /**
     * 状态，1-配送系统已接单，20-已分配骑手，80-骑手已到店，2-配送中，3-已送达，5-系统拒单/配送异常
     */
    private Integer status;
    /**
     * 蜂鸟配送员姓名
     */
    private String carrierDriverName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * '蜂鸟配送员电话'
     */
    private String carrierDriverPhone = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 描述信息
     */
    private String description = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 配送站名字
     */
    private String stationName = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 配送站电话
     */
    private String stationTel = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 订单取消原因. 1:用户取消, 2:商家取消
     */
    private Integer cancelReason = Constants.INT_DEFAULT_VALUE;
    /**
     * 错误编码
     */
    private String errorCode = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 定点次日达服务独有的字段: 微仓地址
     */
    private String address = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 定点次日达服务独有的字段: 微仓经度
     */
    private String longitude = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 定点次日达服务独有的字段: 微仓纬度
     */
    private String latitude = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 消息推送时间
     */
    private Date pushTime;

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

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public String getDietOrderNumber() {
        return dietOrderNumber;
    }

    public void setDietOrderNumber(String dietOrderNumber) {
        this.dietOrderNumber = dietOrderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCarrierDriverName() {
        return carrierDriverName;
    }

    public void setCarrierDriverName(String carrierDriverName) {
        this.carrierDriverName = carrierDriverName;
    }

    public String getCarrierDriverPhone() {
        return carrierDriverPhone;
    }

    public void setCarrierDriverPhone(String carrierDriverPhone) {
        this.carrierDriverPhone = carrierDriverPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationTel() {
        return stationTel;
    }

    public void setStationTel(String stationTel) {
        this.stationTel = stationTel;
    }

    public Integer getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(Integer cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}
