package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DietOrderDetailGoodsFlavor extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 餐厅订单明细ID，diet_order_detail.id
     */
    private BigInteger dietOrderDetailId;
    /**
     * 口味组名称，goods_flavor_group.name
     */
    private String goodsFlavorGroupName;
    /**
     * 口味名称，goods_flavor.name
     */
    private String goodsFlavorName;
    /**
     * 口味加价，goods_flavor.price
     */
    private BigDecimal price;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getDietOrderDetailId() {
        return dietOrderDetailId;
    }

    public void setDietOrderDetailId(BigInteger dietOrderDetailId) {
        this.dietOrderDetailId = dietOrderDetailId;
    }

    public String getGoodsFlavorGroupName() {
        return goodsFlavorGroupName;
    }

    public void setGoodsFlavorGroupName(String goodsFlavorGroupName) {
        this.goodsFlavorGroupName = goodsFlavorGroupName;
    }

    public String getGoodsFlavorName() {
        return goodsFlavorName;
    }

    public void setGoodsFlavorName(String goodsFlavorName) {
        this.goodsFlavorName = goodsFlavorName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
