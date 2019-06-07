package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.annotations.Transient;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;

@ShardingColumn(fieldName = Goods.FieldName.TENANT_ID, columnName = Goods.ColumnName.TENANT_ID)
public class Goods extends BasicDomain {
    public static final String TABLE_NAME = "goods";
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
     * 商品名称
     */
    private String name;
    /**
     * 商品名称，1-普通商品，2-套餐
     */
    private Integer type;
    /**
     * 商品分类ID
     */
    private BigInteger categoryId;

    @Transient
    private String categoryName;
    /**
     * 图片路径
     */
    private String imageUrl = Constants.VARCHAR_DEFAULT_VALUE;

    private boolean stocked;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStocked() {
        return stocked;
    }

    public void setStocked(boolean stocked) {
        this.stocked = stocked;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Goods> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder categoryId(BigInteger categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder categoryName(String categoryName) {
            instance.setCategoryName(categoryName);
            return this;
        }

        public Builder imageUrl(String id) {
            instance.setImageUrl(id);
            return this;
        }

        public Builder stocked(boolean stocked) {
            instance.setStocked(stocked);
            return this;
        }

        @Override
        public Goods build() {
            Goods goods = super.build();
            goods.setTenantId(instance.getTenantId());
            goods.setTenantCode(instance.getTenantCode());
            goods.setBranchId(instance.getBranchId());
            goods.setName(instance.getTenantCode());
            goods.setType(instance.getType());
            goods.setCategoryId(instance.getCategoryId());
            goods.setCategoryName(instance.getCategoryName());
            goods.setImageUrl(instance.getImageUrl());
            goods.setStocked(instance.isStocked());
            return goods;
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
        public static final String TYPE = "type";
        public static final String CATEGORY_ID = "category_id";
        public static final String IMAGE_URL = "image_url";
        public static final String STOCKED = "stocked";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String CATEGORY_ID = "categoryId";
        public static final String CATEGORY_NAME = "categoryName";
        public static final String IMAGE_URL = "imageUrl";
        public static final String STOCKED = "stocked";
    }
}
