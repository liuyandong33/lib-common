package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class GoodsCategory extends BasicDomain {
    /**
     * 门店ID
     */
    private BigInteger tenantId;
    /**
     * 商户ID
     */
    private BigInteger branchId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;
    /**
     * 上级分类ID
     */
    private BigInteger parentId;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }
}
