package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = PackageGroupDetail.FieldName.TENANT_ID, columnName = PackageGroupDetail.ColumnName.TENANT_ID)
public class PackageGroupDetail extends BasicDomain {
    public static final String TABLE_NAME = "package_group_detail";
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
     * 套餐ID
     */
    private BigInteger packageId;
    /**
     * 套餐组ID
     */
    private BigInteger packageGroupId;
    /**
     * 商品ID
     */
    private BigInteger goodsId;
    /**
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;
    /**
     * 数量
     */
    private Integer quantity = Constants.INT_DEFAULT_VALUE;

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

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public BigInteger getPackageGroupId() {
        return packageGroupId;
    }

    public void setPackageGroupId(BigInteger packageGroupId) {
        this.packageGroupId = packageGroupId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Builder {
        private final PackageGroupDetail instance = new PackageGroupDetail();

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

        public Builder packageId(BigInteger packageId) {
            instance.setPackageId(packageId);
            return this;
        }

        public Builder packageGroupId(BigInteger packageGroupId) {
            instance.setPackageGroupId(packageGroupId);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder quantity(Integer quantity) {
            instance.setQuantity(quantity);
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

        public PackageGroupDetail build() {
            PackageGroupDetail packageGroupDetail = new PackageGroupDetail();
            packageGroupDetail.setTenantId(instance.getTenantId());
            packageGroupDetail.setTenantCode(instance.getTenantCode());
            packageGroupDetail.setBranchId(instance.getBranchId());
            packageGroupDetail.setPackageId(instance.getPackageId());
            packageGroupDetail.setPackageGroupId(instance.getPackageGroupId());
            packageGroupDetail.setGoodsId(instance.getGoodsId());
            packageGroupDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            packageGroupDetail.setQuantity(instance.getQuantity());
            packageGroupDetail.setId(instance.getId());
            packageGroupDetail.setCreatedTime(instance.getCreatedTime());
            packageGroupDetail.setCreatedUserId(instance.getCreatedUserId());
            packageGroupDetail.setUpdatedTime(instance.getUpdatedTime());
            packageGroupDetail.setUpdatedUserId(instance.getUpdatedUserId());
            packageGroupDetail.setUpdatedRemark(instance.getUpdatedRemark());
            packageGroupDetail.setDeletedTime(instance.getDeletedTime());
            packageGroupDetail.setDeleted(instance.isDeleted());
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
