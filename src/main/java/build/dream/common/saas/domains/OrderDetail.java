package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OrderDetail extends BasicDomain {
    public static final String TABLE_NAME = "order_detail";
    /**
     * 订单ID
     */
    private BigInteger orderInfoId;
    /**
     * 产品ID
     */
    private BigInteger goodsId;
    /**
     * 产品名称
     */
    private String goodsName;
    /**
     * 产品规格ID
     */
    private BigInteger goodsSpecificationId;
    /**
     * 产品规格名称
     */
    private String goodsSpecificationName;
    /**
     * 门店ID
     */
    private BigInteger branchId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 单价
     */
    private BigDecimal price;
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
     * 数量
     */
    private Integer quantity;

    public BigInteger getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(BigInteger orderInfoId) {
        this.orderInfoId = orderInfoId;
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

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Builder {
        private final OrderDetail instance = new OrderDetail();

        public Builder orderInfoId(BigInteger orderInfoId) {
            instance.setOrderInfoId(orderInfoId);
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

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
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

        public OrderDetail build() {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderInfoId(instance.getOrderInfoId());
            orderDetail.setGoodsId(instance.getGoodsId());
            orderDetail.setGoodsName(instance.getGoodsName());
            orderDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            orderDetail.setGoodsSpecificationName(instance.getGoodsSpecificationName());
            orderDetail.setBranchId(instance.getBranchId());
            orderDetail.setPrice(instance.getPrice());
            orderDetail.setTotalAmount(instance.getTotalAmount());
            orderDetail.setDiscountAmount(instance.getDiscountAmount());
            orderDetail.setPayableAmount(instance.getPayableAmount());
            orderDetail.setQuantity(instance.getQuantity());
            orderDetail.setId(instance.getId());
            orderDetail.setCreatedTime(instance.getCreatedTime());
            orderDetail.setCreatedUserId(instance.getCreatedUserId());
            orderDetail.setUpdatedTime(instance.getUpdatedTime());
            orderDetail.setUpdatedUserId(instance.getUpdatedUserId());
            orderDetail.setUpdatedRemark(instance.getUpdatedRemark());
            orderDetail.setDeletedTime(instance.getDeletedTime());
            orderDetail.setDeleted(instance.isDeleted());
            return orderDetail;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ORDER_INFO_ID = "order_info_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_NAME = "goods_name";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String GOODS_SPECIFICATION_NAME = "goods_specification_name";
        public static final String BRANCH_ID = "branch_id";
        public static final String PRICE = "price";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String DISCOUNT_AMOUNT = "discount_amount";
        public static final String PAYABLE_AMOUNT = "payable_amount";
        public static final String QUANTITY = "quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ORDER_INFO_ID = "orderInfoId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_NAME = "goodsName";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String GOODS_SPECIFICATION_NAME = "goodsSpecificationName";
        public static final String BRANCH_ID = "branchId";
        public static final String PRICE = "price";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String DISCOUNT_AMOUNT = "discountAmount";
        public static final String PAYABLE_AMOUNT = "payableAmount";
        public static final String QUANTITY = "quantity";
    }
}
