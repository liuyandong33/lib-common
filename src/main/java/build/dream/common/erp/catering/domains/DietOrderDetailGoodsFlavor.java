package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DietOrderDetailGoodsFlavor extends BasicDomain {
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
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 餐厅订单明细ID，diet_order_detail.id
     */
    private BigInteger dietOrderDetailId;
    /**
     * 订单组id
     */
    private BigInteger dietOrderGroupId;
    /**
     * 口味组ID，goods_flavor_group.id
     */
    private BigInteger goodsFlavorGroupId;
    /**
     * 口味组名称，goods_flavor_group.name
     */
    private String goodsFlavorGroupName;
    /**
     * 口味ID，goods_flavor.id
     */
    private BigInteger goodsFlavorId;
    /**
     * 口味名称，goods_flavor.name
     */
    private String goodsFlavorName;
    /**
     * 口味加价，goods_flavor.price
     */
    private BigDecimal price;
    /**
     * 本地ID
     */
    private String localId;
    /**
     * 本地订单ID
     */
    private String localDietOrderId;
    /**
     * 本地订单组ID
     */
    private String localDietOrderGroupId;
    /**
     * 本地创建时间
     */
    private Date localCreateTime;
    /**
     * 本地最后更新时间
     */
    private Date localLastUpdateTime;

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

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public BigInteger getDietOrderDetailId() {
        return dietOrderDetailId;
    }

    public void setDietOrderDetailId(BigInteger dietOrderDetailId) {
        this.dietOrderDetailId = dietOrderDetailId;
    }

    public BigInteger getDietOrderGroupId() {
        return dietOrderGroupId;
    }

    public void setDietOrderGroupId(BigInteger dietOrderGroupId) {
        this.dietOrderGroupId = dietOrderGroupId;
    }

    public BigInteger getGoodsFlavorGroupId() {
        return goodsFlavorGroupId;
    }

    public void setGoodsFlavorGroupId(BigInteger goodsFlavorGroupId) {
        this.goodsFlavorGroupId = goodsFlavorGroupId;
    }

    public String getGoodsFlavorGroupName() {
        return goodsFlavorGroupName;
    }

    public void setGoodsFlavorGroupName(String goodsFlavorGroupName) {
        this.goodsFlavorGroupName = goodsFlavorGroupName;
    }

    public BigInteger getGoodsFlavorId() {
        return goodsFlavorId;
    }

    public void setGoodsFlavorId(BigInteger goodsFlavorId) {
        this.goodsFlavorId = goodsFlavorId;
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

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalDietOrderId() {
        return localDietOrderId;
    }

    public void setLocalDietOrderId(String localDietOrderId) {
        this.localDietOrderId = localDietOrderId;
    }

    public String getLocalDietOrderGroupId() {
        return localDietOrderGroupId;
    }

    public void setLocalDietOrderGroupId(String localDietOrderGroupId) {
        this.localDietOrderGroupId = localDietOrderGroupId;
    }

    public Date getLocalCreateTime() {
        return localCreateTime;
    }

    public void setLocalCreateTime(Date localCreateTime) {
        this.localCreateTime = localCreateTime;
    }

    public Date getLocalLastUpdateTime() {
        return localLastUpdateTime;
    }

    public void setLocalLastUpdateTime(Date localLastUpdateTime) {
        this.localLastUpdateTime = localLastUpdateTime;
    }
}
