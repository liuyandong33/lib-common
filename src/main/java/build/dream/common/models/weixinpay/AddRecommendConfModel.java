package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddRecommendConfModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String mchId;

    @NotNull
    @Length(max = 32)
    private String subMchId;

    @NotNull
    @Length(max = 32)
    private String subAppId;

    @Length(max = 32)
    private String subscribeAppId;

    @Length(max = 32)
    private String receiptAppId;

    @InList(value = {Constants.HMAC_SHA256})
    private String signType;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubscribeAppId() {
        return subscribeAppId;
    }

    public void setSubscribeAppId(String subscribeAppId) {
        this.subscribeAppId = subscribeAppId;
    }

    public String getReceiptAppId() {
        return receiptAppId;
    }

    public void setReceiptAppId(String receiptAppId) {
        this.receiptAppId = receiptAppId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public boolean validate() {
        return super.validate() && (StringUtils.isNotBlank(subscribeAppId) || StringUtils.isNotBlank(receiptAppId));
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(subscribeAppId) || StringUtils.isNotBlank(receiptAppId), "参数subscribeAppId和subscribeAppId不能同时为空！");
    }
}
