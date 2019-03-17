package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = TableArea.FieldName.TENANT_ID, columnName = TableArea.ColumnName.TENANT_ID)
public class TableArea extends BasicDomain {
    public static final String TABLE_NAME = "table_area";
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
     * 桌台区域名称
     */
    private String name;

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

    public static class Builder {
        private final TableArea instance = new TableArea();

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

        public TableArea build() {
            TableArea tableArea = new TableArea();
            tableArea.setTenantId(instance.getTenantId());
            tableArea.setTenantCode(instance.getTenantCode());
            tableArea.setName(instance.getName());
            tableArea.setId(instance.getId());
            tableArea.setCreatedTime(instance.getCreatedTime());
            tableArea.setCreatedUserId(instance.getCreatedUserId());
            tableArea.setUpdatedTime(instance.getUpdatedTime());
            tableArea.setUpdatedUserId(instance.getUpdatedUserId());
            tableArea.setUpdatedRemark(instance.getUpdatedRemark());
            tableArea.setDeletedTime(instance.getDeletedTime());
            tableArea.setDeleted(instance.isDeleted());
            return tableArea;
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
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
    }
}
