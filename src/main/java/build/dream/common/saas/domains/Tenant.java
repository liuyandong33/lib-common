package build.dream.common.saas.domains;

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

        @Override
        public Tenant build() {
            Tenant tenant = super.build();
            tenant.setCode(instance.getCode());
            tenant.setName(instance.getName());
            tenant.setBusiness(instance.getBusiness());
            tenant.setPartitionCode(instance.getPartitionCode());
            tenant.setTenantType(instance.getTenantType());
            tenant.setVipSharedType(instance.getVipSharedType());
            tenant.setAgentId(instance.getAgentId());
            tenant.setUsedChannelType(instance.getUsedChannelType());
            tenant.setDadaSourceId(instance.getDadaSourceId());
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
        public static final String PARTITION_CODE = "partition_code";
        public static final String TENANT_TYPE = "tenant_type";
        public static final String VIP_SHARED_TYPE = "vip_shared_type";
        public static final String AGENT_ID = "agent_id";
        public static final String USED_CHANNEL_TYPE = "used_channel_type";
        public static final String DADA_SOURCE_ID = "dada_source_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String BUSINESS = "business";
        public static final String PARTITION_CODE = "partitionCode";
        public static final String TENANT_TYPE = "tenantType";
        public static final String VIP_SHARED_TYPE = "vipSharedType";
        public static final String AGENT_ID = "agentId";
        public static final String USED_CHANNEL_TYPE = "usedChannelType";
        public static final String DADA_SOURCE_ID = "dadaSourceId";
    }
}
