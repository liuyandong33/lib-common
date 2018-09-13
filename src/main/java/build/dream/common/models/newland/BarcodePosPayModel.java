package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BarcodePosPayModel extends CommonModel {
    @NotNull
    private Integer amount;

    @NotNull
    private Integer totalAmount;

    @NotNull
    @InList(value = {Constants.ALIPAY, Constants.WXPAY, Constants.YLPAY})
    private String payChannel;

    @Length(max = 512)
    private String subject;

    @Length(max = 50)
    private String selOrderNo;

    @Length(max = 512)
    private String goodsTag;

    @Length(max = 512)
    private String attach;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSelOrderNo() {
        return selOrderNo;
    }

    public void setSelOrderNo(String selOrderNo) {
        this.selOrderNo = selOrderNo;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
