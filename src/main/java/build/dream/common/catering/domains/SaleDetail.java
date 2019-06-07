package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = SaleDetail.FieldName.TENANT_ID, columnName = SaleDetail.ColumnName.TENANT_ID)
public class SaleDetail extends BasicDomain {
    public static final String TABLE_NAME = "sale_detail";
    /**
     * sale.id
     */
    private BigInteger saleId;
    /**
     * 销售时间
     */
    private Date saleTime;
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
     * 产品ID，goods.id
     */
    private BigInteger goodsId;
    /**
     * 产品名称，goods.name
     */
    private String goodsName;
    /**
     * 商品规格ID，goodsSpecification.id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 商品规格名称，goodsSpecification.name
     */
    private String goodsSpecificationName;
    /**
     * 商品分类ID
     */
    private BigInteger categoryId;
    /**
     * 商品分类名称
     */
    private String categoryName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 总数量
     */
    private BigDecimal quantity;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 优惠分摊金额
     */
    private BigDecimal discountShare;

    public BigInteger getSaleId() {
        return saleId;
    }

    public void setSaleId(BigInteger saleId) {
        this.saleId = saleId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public String getGoodsSpecificationName() {
        return goodsSpecificationName;
    }

    public void setGoodsSpecificationName(String goodsSpecificationName) {
        this.goodsSpecificationName = goodsSpecificationName;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getDiscountShare() {
        return discountShare;
    }

    public void setDiscountShare(BigDecimal discountShare) {
        this.discountShare = discountShare;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SaleDetail> {
        public Builder saleId(BigInteger saleId) {
            instance.setSaleId(saleId);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
            return this;
        }

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

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsSpecificationName(String goodsSpecificationName) {
            instance.setGoodsSpecificationName(goodsSpecificationName);
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

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(BigDecimal discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(BigDecimal payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder discountShare(BigDecimal discountShare) {
            instance.setDiscountShare(discountShare);
            return this;
        }

        @Override
        public SaleDetail build() {
            SaleDetail saleDetail = super.build();
            saleDetail.setSaleId(instance.getSaleId());
            saleDetail.setSaleTime(instance.getSaleTime());
            saleDetail.setTenantId(instance.getTenantId());
            saleDetail.setTenantCode(instance.getTenantCode());
            saleDetail.setBranchId(instance.getBranchId());
            saleDetail.setGoodsId(instance.getGoodsId());
            saleDetail.setGoodsName(instance.getGoodsName());
            saleDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            saleDetail.setGoodsSpecificationName(instance.getGoodsSpecificationName());
            saleDetail.setCategoryId(instance.getCategoryId());
            saleDetail.setCategoryName(instance.getCategoryName());
            saleDetail.setPrice(instance.getPrice());
            saleDetail.setQuantity(instance.getQuantity());
            saleDetail.setTotalAmount(instance.getTotalAmount());
            saleDetail.setDiscountAmount(instance.getDiscountAmount());
            saleDetail.setPayableAmount(instance.getPayableAmount());
            saleDetail.setDiscountShare(instance.getDiscountShare());
            return saleDetail;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SALE_ID = "sale_id";
        public static final String SALE_TIME = "sale_time";
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_NAME = "goods_name";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String GOODS_SPECIFICATION_NAME = "goods_specification_name";
        public static final String CATEGORY_ID = "category_id";
        public static final String CATEGORY_NAME = "category_name";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String DISCOUNT_SHARE = "discount_share";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SALE_ID = "saleId";
        public static final String SALE_TIME = "saleTime";
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_NAME = "goodsName";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String GOODS_SPECIFICATION_NAME = "goodsSpecificationName";
        public static final String CATEGORY_ID = "categoryId";
        public static final String CATEGORY_NAME = "categoryName";
        public static final String PRICE = "price";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String DISCOUNT_SHARE = "discountShare";
    }
}
