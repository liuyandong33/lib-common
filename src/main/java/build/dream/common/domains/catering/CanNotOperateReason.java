package build.dream.common.domains.catering;

public class CanNotOperateReason {
    public static final String TABLE_NAME = "can_not_operate_reason";
    /**
     * id
     */
    private Long id;
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
     * 表id
     */
    private Long tableId;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 导致不能删除的表id
     */
    private Long causeTableId;
    /**
     * 导致不能删除的表名字
     */
    private String causeTableName;
    /**
     * 操作类型，1-编辑，2-删除，3-编辑和删除
     */
    private Integer operateType;
    /**
     * 原因
     */
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getCauseTableId() {
        return causeTableId;
    }

    public void setCauseTableId(Long causeTableId) {
        this.causeTableId = causeTableId;
    }

    public String getCauseTableName() {
        return causeTableName;
    }

    public void setCauseTableName(String causeTableName) {
        this.causeTableName = causeTableName;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class Builder {
        private final CanNotOperateReason instance = new CanNotOperateReason();

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

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

        public Builder tableId(Long tableId) {
            instance.setTableId(tableId);
            return this;
        }

        public Builder tableName(String tableName) {
            instance.setTableName(tableName);
            return this;
        }

        public Builder causeTableId(Long causeTableId) {
            instance.setCauseTableId(causeTableId);
            return this;
        }

        public Builder causeTableName(String causeTableName) {
            instance.setCauseTableName(causeTableName);
            return this;
        }

        public Builder operateType(Integer operateType) {
            instance.setOperateType(operateType);
            return this;
        }

        public Builder reason(String reason) {
            instance.setReason(reason);
            return this;
        }

        public CanNotOperateReason build() {
            CanNotOperateReason canNotOperateReason = new CanNotOperateReason();
            canNotOperateReason.setId(instance.getId());
            canNotOperateReason.setTenantId(instance.getTenantId());
            canNotOperateReason.setTenantCode(instance.getTenantCode());
            canNotOperateReason.setBranchId(instance.getBranchId());
            canNotOperateReason.setTableId(instance.getTableId());
            canNotOperateReason.setTableName(instance.getTableName());
            canNotOperateReason.setCauseTableId(instance.getCauseTableId());
            canNotOperateReason.setCauseTableName(instance.getCauseTableName());
            canNotOperateReason.setOperateType(instance.getOperateType());
            canNotOperateReason.setReason(instance.getReason());
            return canNotOperateReason;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName {
        public static final String ID = "id";
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String TABLE_ID = "table_id";
        public static final String TABLE_NAME = "table_name";
        public static final String CAUSE_TABLE_ID = "cause_table_id";
        public static final String CAUSE_TABLE_NAME = "cause_table_name";
        public static final String OPERATE_TYPE = "operate_type";
        public static final String REASON = "reason";
    }

    public static final class FieldName {
        public static final String ID = "id";
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String TABLE_ID = "tableId";
        public static final String TABLE_NAME = "tableName";
        public static final String CAUSE_TABLE_ID = "causeTableId";
        public static final String CAUSE_TABLE_NAME = "causeTableName";
        public static final String OPERATE_TYPE = "operateType";
        public static final String REASON = "reason";
    }
}
