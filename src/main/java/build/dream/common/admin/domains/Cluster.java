package build.dream.common.admin.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class Cluster extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 集群名称
     */
    private String name;
    /**
     * 集群类型，1-zookeeper 集群
     */
    private Integer type;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
