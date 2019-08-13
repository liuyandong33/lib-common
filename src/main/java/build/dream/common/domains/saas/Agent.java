package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class Agent extends BasicDomain {
    public static final String TABLE_NAME = "agent";
    /**
     * 代理商编码
     */
    private String code;
    /**
     * 代理商名称
     */
    private String name;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱地址
     */
    private String email;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static class Builder extends BasicDomain.Builder<Builder, Agent> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder linkman(String linkman) {
            instance.setLinkman(linkman);
            return this;
        }

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
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

        @Override
        public Agent build() {
            Agent agent = super.build();
            agent.setCode(instance.getCode());
            agent.setName(instance.getName());
            agent.setLinkman(instance.getLinkman());
            agent.setMobile(instance.getMobile());
            agent.setEmail(instance.getEmail());
            agent.setProvinceCode(instance.getProvinceCode());
            agent.setProvinceName(instance.getProvinceName());
            agent.setCityCode(instance.getCityCode());
            agent.setCityName(instance.getCityName());
            agent.setDistrictCode(instance.getDistrictCode());
            agent.setDistrictName(instance.getDistrictName());
            agent.setAddress(instance.getAddress());
            return agent;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String LINKMAN = "linkman";
        public static final String MOBILE = "mobile";
        public static final String EMAIL = "email";
        public static final String PROVINCE_CODE = "province_code";
        public static final String PROVINCE_NAME = "province_name";
        public static final String CITY_CODE = "city_code";
        public static final String CITY_NAME = "city_name";
        public static final String DISTRICT_CODE = "district_code";
        public static final String DISTRICT_NAME = "district_name";
        public static final String ADDRESS = "address";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String LINKMAN = "linkman";
        public static final String MOBILE = "mobile";
        public static final String EMAIL = "email";
        public static final String PROVINCE_CODE = "provinceCode";
        public static final String PROVINCE_NAME = "provinceName";
        public static final String CITY_CODE = "cityCode";
        public static final String CITY_NAME = "cityName";
        public static final String DISTRICT_CODE = "districtCode";
        public static final String DISTRICT_NAME = "districtName";
        public static final String ADDRESS = "address";
    }
}
