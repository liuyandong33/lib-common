package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class AgentForm extends BasicDomain {
    /**
     * 代理商名称
     */
    private String name;
    /**
     * 状态，1-未审核，2-已审核，3-已驳回
     */
    private Integer status;
    /**
     * 省编码
     */
    private String provinceCode;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市编码
     */
    private String cityCode;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区编码
     */
    private String districtCode;
    /**
     * 区名称
     */
    private String districtName;
    /**
     * 门店详细地址
     */
    private String address;
    /**
     * 审核用户ID
     */
    private BigInteger verifyUserId;
    /**
     * 驳回原因
     */
    private String rejectReason;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(BigInteger verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AgentForm> {
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder provinceCode(String provinceCode) {
            instance.setProvinceCode(provinceCode);
            return this;
        }

        public Builder provinceName(String provinceName) {
            instance.setProvinceName(provinceName);
            return this;
        }

        public Builder cityCode(String cityCode) {
            instance.setCityCode(cityCode);
            return this;
        }

        public Builder cityName(String cityName) {
            instance.setCityName(cityName);
            return this;
        }

        public Builder districtCode(String districtCode) {
            instance.setDistrictCode(districtCode);
            return this;
        }

        public Builder districtName(String districtName) {
            instance.setDistrictName(districtName);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder verifyUserId(BigInteger verifyUserId) {
            instance.setVerifyUserId(verifyUserId);
            return this;
        }

        public Builder rejectReason(String rejectReason) {
            instance.setRejectReason(rejectReason);
            return this;
        }

        @Override
        public AgentForm build() {
            AgentForm agentForm = super.build();
            agentForm.setName(instance.getName());
            agentForm.setStatus(instance.getStatus());
            agentForm.setProvinceCode(instance.getProvinceCode());
            agentForm.setProvinceName(instance.getProvinceName());
            agentForm.setCityCode(instance.getCityCode());
            agentForm.setCityName(instance.getCityName());
            agentForm.setDistrictCode(instance.getDistrictCode());
            agentForm.setDistrictName(instance.getDistrictName());
            agentForm.setAddress(instance.getAddress());
            agentForm.setVerifyUserId(instance.getVerifyUserId());
            agentForm.setRejectReason(instance.getRejectReason());
            return agentForm;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String PROVINCE_CODE = "province_code";
        public static final String PROVINCE_NAME = "province_name";
        public static final String CITY_CODE = "city_code";
        public static final String CITY_NAME = "city_name";
        public static final String DISTRICT_CODE = "district_code";
        public static final String DISTRICT_NAME = "district_name";
        public static final String ADDRESS = "address";
        public static final String VERIFY_USER_ID = "verify_user_id";
        public static final String REJECT_REASON = "reject_reason";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String PROVINCE_CODE = "provinceCode";
        public static final String PROVINCE_NAME = "provinceName";
        public static final String CITY_CODE = "cityCode";
        public static final String CITY_NAME = "cityName";
        public static final String DISTRICT_CODE = "districtCode";
        public static final String DISTRICT_NAME = "districtName";
        public static final String ADDRESS = "address";
        public static final String VERIFY_USER_ID = "verifyUserId";
        public static final String REJECT_REASON = "rejectReason";
    }
}
