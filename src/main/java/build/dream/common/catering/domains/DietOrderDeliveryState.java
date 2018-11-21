package build.dream.common.catering.domains;

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

    public static class Builder {
        private final DietOrderDeliveryState instance = new DietOrderDeliveryState();

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

        public Builder dietOrderId(BigInteger dietOrderId) {
            instance.setDietOrderId(dietOrderId);
            return this;
        }

        public Builder dietOrderNumber(String dietOrderNumber) {
            instance.setDietOrderNumber(dietOrderNumber);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder carrierDriverName(String carrierDriverName) {
            instance.setCarrierDriverName(carrierDriverName);
            return this;
        }

        public Builder carrierDriverPhone(String carrierDriverPhone) {
            instance.setCarrierDriverPhone(carrierDriverPhone);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder stationName(String stationName) {
            instance.setStationName(stationName);
            return this;
        }

        public Builder stationTel(String stationTel) {
            instance.setStationTel(stationTel);
            return this;
        }

        public Builder cancelReason(Integer cancelReason) {
            instance.setCancelReason(cancelReason);
            return this;
        }

        public Builder errorCode(String errorCode) {
            instance.setErrorCode(errorCode);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder longitude(String longitude) {
            instance.setLongitude(longitude);
            return this;
        }

        public Builder latitude(String latitude) {
            instance.setLatitude(latitude);
            return this;
        }

        public Builder pushTime(Date pushTime) {
            instance.setPushTime(pushTime);
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

        public DietOrderDeliveryState build() {
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
        public static final String DIET_ORDER_ID = "diet_order_id";
        public static final String DIET_ORDER_NUMBER = "diet_order_number";
        public static final String STATUS = "status";
        public static final String CARRIER_DRIVER_NAME = "carrier_driver_name";
        public static final String CARRIER_DRIVER_PHONE = "carrier_driver_phone";
        public static final String DESCRIPTION = "description";
        public static final String STATION_NAME = "station_name";
        public static final String STATION_TEL = "station_tel";
        public static final String CANCEL_REASON = "cancel_reason";
        public static final String ERROR_CODE = "error_code";
        public static final String ADDRESS = "address";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String PUSH_TIME = "push_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DIET_ORDER_ID = "dietOrderId";
        public static final String DIET_ORDER_NUMBER = "dietOrderNumber";
        public static final String STATUS = "status";
        public static final String CARRIER_DRIVER_NAME = "carrierDriverName";
        public static final String CARRIER_DRIVER_PHONE = "carrierDriverPhone";
        public static final String DESCRIPTION = "description";
        public static final String STATION_NAME = "stationName";
        public static final String STATION_TEL = "stationTel";
        public static final String CANCEL_REASON = "cancelReason";
        public static final String ERROR_CODE = "errorCode";
        public static final String ADDRESS = "address";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String PUSH_TIME = "pushTime";
    }
}
