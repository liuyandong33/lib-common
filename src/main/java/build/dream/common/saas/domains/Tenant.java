package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class Tenant extends BasicDomain {
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
}
