package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ElemeOrderActivity extends BasicDomain {
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
     * eleme_order.id
     */
    private BigInteger elemeOrderId;
    /**
     * 饿了么系统订单ID
     */
    private String orderId;
    /**
     * 饿了么活动ID
     */
    private BigInteger elemeActivityId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动类别
     */
    private Integer categoryId;
    /**
     * 饿了么承担部分
     */
    private BigDecimal elemePart;
    /**
     * 商家承担部分
     */
    private BigDecimal restaurantPart;
    /**
     * 金额
     */
    private BigDecimal amount;

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

    public BigInteger getElemeOrderId() {
        return elemeOrderId;
    }

    public void setElemeOrderId(BigInteger elemeOrderId) {
        this.elemeOrderId = elemeOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getElemeActivityId() {
        return elemeActivityId;
    }

    public void setElemeActivityId(BigInteger elemeActivityId) {
        this.elemeActivityId = elemeActivityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getElemePart() {
        return elemePart;
    }

    public void setElemePart(BigDecimal elemePart) {
        this.elemePart = elemePart;
    }

    public BigDecimal getRestaurantPart() {
        return restaurantPart;
    }

    public void setRestaurantPart(BigDecimal restaurantPart) {
        this.restaurantPart = restaurantPart;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
