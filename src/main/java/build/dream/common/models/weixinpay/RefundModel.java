package build.dream.common.models.weixinpay;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundModel extends BasicModel {
    private static final String[] TRADE_TYPES = {Constants.WEI_XIN_PAY_TRADE_TYPE_JSAPI, Constants.WEI_XIN_PAY_TRADE_TYPE_NATIVE, Constants.WEI_XIN_PAY_TRADE_TYPE_APP, Constants.WEI_XIN_PAY_TRADE_TYPE_MWEB, Constants.WEI_XIN_PAY_TRADE_TYPE_MICROPAY};
    private static final String[] REFUNDS_ACCOUNTS = {"REFUND_SOURCE_UNSETTLED_FUNDS", "REFUND_SOURCE_RECHARGE_FUNDS"};
    private static final String[] REFUND_FEE_TYPES = {"CNY"};

    @Length(max = 32)
    private String transactionId;

    @Length(max = 32)
    private String outTradeNo;

    @NotNull
    @Length(max = 64)
    private String outRefundNo;

    @NotNull
    private Integer totalFee;

    @NotNull
    private Integer refundFee;

    private String refundFeeType;

    @Length(max = 80)
    private String refund_desc;

    private String refundAccount;

    private String tradeType;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefund_desc() {
        return refund_desc;
    }

    public void setRefund_desc(String refund_desc) {
        this.refund_desc = refund_desc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ValidateUtils.isTrue(StringUtils.isNotBlank(transactionId) || StringUtils.isNotBlank(outTradeNo), "参数transactionId，outTradeNo不能同时为空！");
        ApplicationHandler.inArray(TRADE_TYPES, tradeType, "tradeType");
        if (StringUtils.isNotBlank(refundFeeType)) {
            ApplicationHandler.inArray(REFUND_FEE_TYPES, refundFeeType, "refundFeeType");
        }
        if (StringUtils.isNotBlank(refundAccount)) {
            ApplicationHandler.inArray(REFUNDS_ACCOUNTS, refundAccount, "refundAccount");
        }
    }
}
