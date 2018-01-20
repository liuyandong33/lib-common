package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GoodsFlavor extends BasicDomain {
    private BigInteger goodsFlavorGroupId;
    private String name;
    private BigDecimal price;

    public BigInteger getGoodsFlavorGroupId() {
        return goodsFlavorGroupId;
    }

    public void setGoodsFlavorGroupId(BigInteger goodsFlavorGroupId) {
        this.goodsFlavorGroupId = goodsFlavorGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
