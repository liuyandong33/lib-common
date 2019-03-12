package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = GoodsCategory.FieldName.TENANT_ID, columnName = GoodsCategory.ColumnName.TENANT_ID)
public class GoodsCategory extends BasicDomain {
    public static final String TABLE_NAME = "goods_category";
    /**
     * 门店ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
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

    public static class Builder {
        private final GoodsCategory instance = new GoodsCategory();

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

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder parentId(BigInteger parentId) {
            instance.setParentId(parentId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public GoodsCategory build() {
            GoodsCategory goodsCategory = new GoodsCategory();
            goodsCategory.setTenantId(instance.getTenantId());
            goodsCategory.setTenantCode(instance.getTenantCode());
            goodsCategory.setBranchId(instance.getBranchId());
            goodsCategory.setName(instance.getName());
            goodsCategory.setDescription(instance.getDescription());
            goodsCategory.setParentId(instance.getParentId());
            goodsCategory.setId(instance.getId());
            goodsCategory.setCreatedTime(instance.getCreatedTime());
            goodsCategory.setCreatedUserId(instance.getCreatedUserId());
            goodsCategory.setUpdatedTime(instance.getUpdatedTime());
            goodsCategory.setUpdatedUserId(instance.getUpdatedUserId());
            goodsCategory.setUpdatedRemark(instance.getUpdatedRemark());
            goodsCategory.setDeletedTime(instance.getDeletedTime());
            goodsCategory.setDeleted(instance.isDeleted());
            return goodsCategory;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String PARENT_ID = "parent_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String PARENT_ID = "parentId";
    }
}
