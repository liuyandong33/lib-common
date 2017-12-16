package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ElemeRefundOrderMessageGoodsItem extends BasicDomain {
    private BigInteger elemeRefundOrderMessageId;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public BigInteger getElemeRefundOrderMessageId() {
        return elemeRefundOrderMessageId;
    }

    public void setElemeRefundOrderMessageId(BigInteger elemeRefundOrderMessageId) {
        this.elemeRefundOrderMessageId = elemeRefundOrderMessageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
