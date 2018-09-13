package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PubSigPayModel extends BasicModel {
    @NotNull
    @Length(min = 14, max = 14)
    private String txnTime;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

    @Length(max = 50)
    private String code;

    @Length(max = 50)
    private String openid;

    private Integer amount;

    private Integer totalAmount;

    @Length(max = 256)
    private String subject;

    @Length(max = 50)
    private String selOrderNo;

    @Length(max = 250)
    private String goodsTag;

    @Length(max = 256)
    private String attach;

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

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

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(code) || StringUtils.isNotBlank(openid));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(code) || StringUtils.isNotBlank(openid), "参数code与openid不能同时为空！");
    }
}
