package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = BranchTable.FieldName.TENANT_ID, columnName = BranchTable.ColumnName.TENANT_ID)
public class BranchTable extends BasicDomain {
    public static final String TABLE_NAME = "branch_table";

    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户编码
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * 桌台区域ID
     */
    private Long tableAreaId;

    /**
     * 桌台编号
     */
    private String code;

    /**
     * 桌台名称
     */
    private String name;

    /**
     * 状态，1-启用，2-禁用
     */
    private Integer status;

    /**
     * 就餐人数
     */
    private Integer dinnersNumber;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getTableAreaId() {
        return tableAreaId;
    }

    public void setTableAreaId(Long tableAreaId) {
        this.tableAreaId = tableAreaId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDinnersNumber() {
        return dinnersNumber;
    }

    public void setDinnersNumber(Integer dinnersNumber) {
        this.dinnersNumber = dinnersNumber;
    }

    public static class Builder extends BasicDomain.Builder<Builder, BranchTable> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder tableAreaId(Long tableAreaId) {
            instance.setTableAreaId(tableAreaId);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder dinnersNumber(Integer dinnersNumber) {
            instance.setDinnersNumber(dinnersNumber);
            return this;
        }

        @Override
        public BranchTable build() {
            BranchTable branchTable = super.build();
            branchTable.setTenantId(instance.getTenantId());
            branchTable.setTenantCode(instance.getTenantCode());
            branchTable.setBranchId(instance.getBranchId());
            branchTable.setTableAreaId(instance.getTableAreaId());
            branchTable.setCode(instance.getCode());
            branchTable.setName(instance.getName());
            branchTable.setStatus(instance.getStatus());
            branchTable.setDinnersNumber(instance.getDinnersNumber());
            return branchTable;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String TABLE_AREA_ID = "table_area_id";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String DINNERS_NUMBER = "dinners_number";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String TABLE_AREA_ID = "tableAreaId";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String DINNERS_NUMBER = "dinnersNumber";
    }
}
