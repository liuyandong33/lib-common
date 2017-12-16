package build.dream.common.erp.catering.domains;

import java.math.BigInteger;

public class ActivityBuyGive extends BasicActivity {
    private BigInteger buyGoodsId;
    private Integer buyAmount;
    private BigInteger giveGoodsId;
    private Integer giveAmount;

    public BigInteger getBuyGoodsId() {
        return buyGoodsId;
    }

    public void setBuyGoodsId(BigInteger buyGoodsId) {
        this.buyGoodsId = buyGoodsId;
    }

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigInteger getGiveGoodsId() {
        return giveGoodsId;
    }

    public void setGiveGoodsId(BigInteger giveGoodsId) {
        this.giveGoodsId = giveGoodsId;
    }

    public Integer getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(Integer giveAmount) {
        this.giveAmount = giveAmount;
    }
}
