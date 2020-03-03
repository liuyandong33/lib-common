package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

public class OrderDetail extends BasicDomain {
    public static final String TABLE_NAME = "order_detail";
    /**
     * 订单ID
     */
    private Long orderInfoId;
    /**
     * 产品ID
     */
    private Long goodsId;
    /**
     * 产品名称
     */
    private String goodsName;
    /**
     * 产品规格ID
     */
    private Long goodsSpecificationId;
    /**
     * 产品规格名称
     */
    private String goodsSpecificationName;
    /**
     * 门店ID
     */
    private Long branchId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 单价
     */
    private Double price;
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
     * 数量
     */
    private Integer quantity;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Builder extends BasicDomain.Builder<Builder, OrderDetail> {
        public Builder orderInfoId(Long orderInfoId) {
            instance.setOrderInfoId(orderInfoId);
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

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder price(Double price) {
            instance.setPrice(price);
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

        public Builder quantity(Integer quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        @Override
        public OrderDetail build() {
            OrderDetail orderDetail = super.build();
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
