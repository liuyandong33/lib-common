package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class Tenant extends BasicDomain {
    public static final String TABLE_NAME = "tenant";
    /**
     * 商户编码
     */
    private String code;
    /**
     * 商户名称
     */
    private String name;
    /**
     * 业态，1-餐饮，2-零售
     */
    private String business;
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
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 分区码
     */
    private String partitionCode;
    /**
     * 商户类型，1-标准版商户，2-单机版商户
     */
    private Integer tenantType;
    /**
     * 会员共享类型，1-全部共享，2-全部独立，3-分组共享
     */
    private Integer vipSharedType;
    /**
     * 代理商ID
     */
    private BigInteger agentId;
    /**
     * 商户使用的支付通道类型，0-原生支付，3-米雅，4-新大陆，5-联动
     */
    private Integer usedChannelType;
    /**
     * 达达商户ID
     */
    private BigInteger dadaSourceId;

    /**
     * 京东到家商家ID
     */
    private String jddjVenderId;

    /**
     * 京东到家授权应用app key
     */
    private String jddjAppKey;

    /**
     * 京东到家授权应用app secret
     */
    private String jddjAppSecret;

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

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public Integer getTenantType() {
        return tenantType;
    }

    public void setTenantType(Integer tenantType) {
        this.tenantType = tenantType;
    }

    public Integer getVipSharedType() {
        return vipSharedType;
    }

    public void setVipSharedType(Integer vipSharedType) {
        this.vipSharedType = vipSharedType;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public Integer getUsedChannelType() {
        return usedChannelType;
    }

    public void setUsedChannelType(Integer usedChannelType) {
        this.usedChannelType = usedChannelType;
    }

    public BigInteger getDadaSourceId() {
        return dadaSourceId;
    }

    public void setDadaSourceId(BigInteger dadaSourceId) {
        this.dadaSourceId = dadaSourceId;
    }

    public String getJddjVenderId() {
        return jddjVenderId;
    }

    public void setJddjVenderId(String jddjVenderId) {
        this.jddjVenderId = jddjVenderId;
    }

    public String getJddjAppKey() {
        return jddjAppKey;
    }

    public void setJddjAppKey(String jddjAppKey) {
        this.jddjAppKey = jddjAppKey;
    }

    public String getJddjAppSecret() {
        return jddjAppSecret;
    }

    public void setJddjAppSecret(String jddjAppSecret) {
        this.jddjAppSecret = jddjAppSecret;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Tenant> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder business(String business) {
            instance.setBusiness(business);
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

        public Builder linkman(String linkman) {
            instance.setLinkman(linkman);
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder tenantType(Integer tenantType) {
            instance.setTenantType(tenantType);
            return this;
        }

        public Builder vipSharedType(Integer vipSharedType) {
            instance.setVipSharedType(vipSharedType);
            return this;
        }

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder usedChannelType(Integer usedChannelType) {
            instance.setUsedChannelType(usedChannelType);
            return this;
        }

        public Builder dadaSourceId(BigInteger dadaSourceId) {
            instance.setDadaSourceId(dadaSourceId);
            return this;
        }

        public Builder jddjVenderId(String jddjVenderId) {
            instance.setJddjVenderId(jddjVenderId);
            return this;
        }

        public Builder jddjAppKey(String jddjAppKey) {
            instance.setJddjAppKey(jddjAppKey);
            return this;
        }

        public Builder jddjAppSecret(String jddjAppSecret) {
            instance.setJddjAppSecret(jddjAppSecret);
            return this;
        }

        @Override
        public Tenant build() {
            Tenant tenant = super.build();
            tenant.setCode(instance.getCode());
            tenant.setName(instance.getName());
            tenant.setBusiness(instance.getBusiness());
            tenant.setProvinceCode(instance.getProvinceCode());
            tenant.setProvinceName(instance.getProvinceName());
            tenant.setCityCode(instance.getCityCode());
            tenant.setCityName(instance.getCityName());
            tenant.setDistrictCode(instance.getDistrictCode());
            tenant.setDistrictName(instance.getDistrictName());
            tenant.setAddress(instance.getAddress());
            tenant.setLinkman(instance.getLinkman());
            tenant.setContactPhone(instance.getContactPhone());
            tenant.setEmail(instance.getEmail());
            tenant.setPartitionCode(instance.getPartitionCode());
            tenant.setTenantType(instance.getTenantType());
            tenant.setVipSharedType(instance.getVipSharedType());
            tenant.setAgentId(instance.getAgentId());
            tenant.setUsedChannelType(instance.getUsedChannelType());
            tenant.setDadaSourceId(instance.getDadaSourceId());
            tenant.setJddjVenderId(instance.getJddjVenderId());
            tenant.setJddjAppKey(instance.getJddjAppKey());
            tenant.setJddjAppSecret(instance.getJddjAppSecret());
            return tenant;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String BUSINESS = "business";
        public static final String PROVINCE_CODE = "province_code";
        public static final String PROVINCE_NAME = "province_name";
        public static final String CITY_CODE = "city_code";
        public static final String CITY_NAME = "city_name";
        public static final String DISTRICT_CODE = "district_code";
        public static final String DISTRICT_NAME = "district_name";
        public static final String ADDRESS = "address";
        public static final String LINKMAN = "linkman";
        public static final String CONTACT_PHONE = "contact_phone";
        public static final String EMAIL = "email";
        public static final String PARTITION_CODE = "partition_code";
        public static final String TENANT_TYPE = "tenant_type";
        public static final String VIP_SHARED_TYPE = "vip_shared_type";
        public static final String AGENT_ID = "agent_id";
        public static final String USED_CHANNEL_TYPE = "used_channel_type";
        public static final String DADA_SOURCE_ID = "dada_source_id";
        public static final String JDDJ_VENDER_ID = "jddj_vender_id";
        public static final String JDDJ_APP_KEY = "jddj_app_key";
        public static final String JDDJ_APP_SECRET = "jddj_app_secret";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String BUSINESS = "business";
        public static final String PROVINCE_CODE = "provinceCode";
        public static final String PROVINCE_NAME = "provinceName";
        public static final String CITY_CODE = "cityCode";
        public static final String CITY_NAME = "cityName";
        public static final String DISTRICT_CODE = "districtCode";
        public static final String DISTRICT_NAME = "districtName";
        public static final String ADDRESS = "address";
        public static final String LINKMAN = "linkman";
        public static final String CONTACT_PHONE = "contactPhone";
        public static final String EMAIL = "email";
        public static final String PARTITION_CODE = "partitionCode";
        public static final String TENANT_TYPE = "tenantType";
        public static final String VIP_SHARED_TYPE = "vipSharedType";
        public static final String AGENT_ID = "agentId";
        public static final String USED_CHANNEL_TYPE = "usedChannelType";
        public static final String DADA_SOURCE_ID = "dadaSourceId";
        public static final String JDDJ_VENDER_ID = "jddjVenderId";
        public static final String JDDJ_APP_KEY = "jddjAppKey";
        public static final String JDDJ_APP_SECRET = "jddjAppSecret";
    }
}
