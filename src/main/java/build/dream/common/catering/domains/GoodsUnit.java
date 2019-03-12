package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = GoodsUnit.FieldName.TENANT_ID, columnName = GoodsUnit.ColumnName.TENANT_ID)
public class GoodsUnit extends BasicDomain {
    public static final String TABLE_NAME = "goods_unit";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 商品ID
     */
    private BigInteger goodsId;
    /**
     * 单位名称
     */
    private String name;
    /**
     * 比例
     */
    private BigDecimal proportion;

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

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public static class Builder {
        private final GoodsUnit instance = new GoodsUnit();

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

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder proportion(BigDecimal proportion) {
            instance.setProportion(proportion);
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

        public GoodsUnit build() {
            GoodsUnit goodsUnit = new GoodsUnit();
            goodsUnit.setTenantId(instance.getTenantId());
            goodsUnit.setTenantCode(instance.getTenantCode());
            goodsUnit.setBranchId(instance.getBranchId());
            goodsUnit.setGoodsId(instance.getGoodsId());
            goodsUnit.setName(instance.getName());
            goodsUnit.setProportion(instance.getProportion());
            goodsUnit.setId(instance.getId());
            goodsUnit.setCreatedTime(instance.getCreatedTime());
            goodsUnit.setCreatedUserId(instance.getCreatedUserId());
            goodsUnit.setUpdatedTime(instance.getUpdatedTime());
            goodsUnit.setUpdatedUserId(instance.getUpdatedUserId());
            goodsUnit.setUpdatedRemark(instance.getUpdatedRemark());
            goodsUnit.setDeletedTime(instance.getDeletedTime());
            goodsUnit.setDeleted(instance.isDeleted());
            return goodsUnit;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String GOODS_ID = "goods_id";
        public static final String NAME = "name";
        public static final String PROPORTION = "proportion";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String NAME = "name";
        public static final String PROPORTION = "proportion";
    }
}
