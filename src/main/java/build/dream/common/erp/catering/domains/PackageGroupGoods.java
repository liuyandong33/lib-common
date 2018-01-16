package build.dream.common.erp.catering.domains;

import java.math.BigInteger;

public class PackageGroupGoods {
    private BigInteger id;
    private BigInteger packageGroupId;
    private BigInteger goodsId;
    private Integer quantity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
