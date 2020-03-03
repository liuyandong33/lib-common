package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.util.Date;

@ShardingColumn(fieldName = SaleDetail.FieldName.TENANT_ID, columnName = SaleDetail.ColumnName.TENANT_ID)
public class SaleDetail extends BasicDomain {
    public static final String TABLE_NAME = "sale_detail";
    /**
     * sale.id
     */
    private Long saleId;
    /**
     * 销售时间
     */
    private Date saleTime;
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
     * 产品ID，goods.id
     */
    private Long goodsId;
    /**
     * 产品名称，goods.name
     */
    private String goodsName;
    /**
     * 商品规格ID，goodsSpecification.id
     */
    private Long goodsSpecificationId;
    /**
     * 商品规格名称，goodsSpecification.name
     */
    private String goodsSpecificationName;
    /**
     * 商品分类ID
     */
    private Long categoryId;
    /**
     * 商品分类名称
     */
    private String categoryName;
    /**
     * 单价
     */
    private Double price;
    /**
     * 总数量
     */
    private Double quantity;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 优惠金额
     */
    private Double discountAmount;
    /**
     * 应付金额
     */
    private Double payableAmount;
    /**
     * 优惠分摊金额
     */
    private Double discountShare;

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Long goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public String getGoodsSpecificationName() {
        return goodsSpecificationName;
    }

    public void setGoodsSpecificationName(String goodsSpecificationName) {
        this.goodsSpecificationName = goodsSpecificationName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getDiscountShare() {
        return discountShare;
    }

    public void setDiscountShare(Double discountShare) {
        this.discountShare = discountShare;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SaleDetail> {
        public Builder saleId(Long saleId) {
            instance.setSaleId(saleId);
            return this;
        }

        public Builder saleTime(Date saleTime) {
            instance.setSaleTime(saleTime);
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

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsSpecificationName(String goodsSpecificationName) {
            instance.setGoodsSpecificationName(goodsSpecificationName);
            return this;
        }

        public Builder categoryId(Long categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder categoryName(String categoryName) {
            instance.setCategoryName(categoryName);
            return this;
        }

        public Builder price(Double price) {
            instance.setPrice(price);
            return this;
        }

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder discountAmount(Double discountAmount) {
            instance.setDiscountAmount(discountAmount);
            return this;
        }

        public Builder payableAmount(Double payableAmount) {
            instance.setPayableAmount(payableAmount);
            return this;
        }

        public Builder discountShare(Double discountShare) {
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
