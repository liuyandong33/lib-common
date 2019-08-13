package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = Menu.FieldName.TENANT_ID, columnName = Menu.ColumnName.TENANT_ID)
public class Menu extends BasicDomain {
    public static final String TABLE_NAME = "menu";
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户编码
     */
    private String tenantCode;

    /**
     * 菜牌编号
     */
    private String code;

    /**
     * 菜牌名称
     */
    private String name;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 菜牌状态，1-正常，2-停用
     */
    private Integer status;

    /**
     * 生效范围，1-线上，2-线下，3-线上线下
     */
    private Integer effectiveScope;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEffectiveScope() {
        return effectiveScope;
    }

    public void setEffectiveScope(Integer effectiveScope) {
        this.effectiveScope = effectiveScope;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Menu> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
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

        public Builder startTime(Date startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Date endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder effectiveScope(Integer effectiveScope) {
            instance.setEffectiveScope(effectiveScope);
            return this;
        }

        @Override
        public Menu build() {
            Menu menu = super.build();
            menu.setTenantId(instance.getTenantId());
            menu.setTenantCode(instance.getTenantCode());
            menu.setCode(instance.getCode());
            menu.setName(instance.getName());
            menu.setStartTime(instance.getStartTime());
            menu.setEndTime(instance.getEndTime());
            menu.setStatus(instance.getStatus());
            menu.setEffectiveScope(instance.getEffectiveScope());
            return menu;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
        public static final String STATUS = "status";
        public static final String EFFECTIVE_SCOPE = "effective_scope";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String STATUS = "status";
        public static final String EFFECTIVE_SCOPE = "effectiveScope";
    }
}
