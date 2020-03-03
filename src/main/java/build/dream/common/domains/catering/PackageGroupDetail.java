package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = PackageGroupDetail.FieldName.TENANT_ID, columnName = PackageGroupDetail.ColumnName.TENANT_ID)
public class PackageGroupDetail extends BasicDomain {
    public static final String TABLE_NAME = "package_group_detail";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 套餐ID
     */
    private Long packageId;
    /**
     * 套餐组ID
     */
    private Long packageGroupId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品规格ID
     */
    private Long goodsSpecificationId;
    /**
     * 数量
     */
    private Integer quantity = Constants.INT_DEFAULT_VALUE;

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

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(Long packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Long goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Builder extends BasicDomain.Builder<Builder, PackageGroupDetail> {
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

        public Builder packageId(Long packageId) {
            instance.setPackageId(packageId);
            return this;
        }

        public Builder packageGroupId(Long packageGroupId) {
            instance.setPackageGroupId(packageGroupId);
            return this;
        }

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder quantity(Integer quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        @Override
        public PackageGroupDetail build() {
            PackageGroupDetail packageGroupDetail = super.build();
            packageGroupDetail.setTenantId(instance.getTenantId());
            packageGroupDetail.setTenantCode(instance.getTenantCode());
            packageGroupDetail.setBranchId(instance.getBranchId());
            packageGroupDetail.setPackageId(instance.getPackageId());
            packageGroupDetail.setPackageGroupId(instance.getPackageGroupId());
            packageGroupDetail.setGoodsId(instance.getGoodsId());
            packageGroupDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            packageGroupDetail.setQuantity(instance.getQuantity());
            return packageGroupDetail;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String PACKAGE_ID = "package_id";
        public static final String PACKAGE_GROUP_ID = "package_group_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String QUANTITY = "quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String PACKAGE_ID = "packageId";
        public static final String PACKAGE_GROUP_ID = "packageGroupId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String QUANTITY = "quantity";
    }
}
