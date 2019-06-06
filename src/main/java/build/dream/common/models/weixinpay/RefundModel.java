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

    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

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
    private String refundDesc;

    private String refundAccount;

    private String tradeType;

    private String topic;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

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

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public static class Builder {
        private RefundModel instance = new RefundModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder transactionId(String transactionId) {
            instance.setTransactionId(transactionId);
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            instance.setOutTradeNo(outTradeNo);
            return this;
        }

        public Builder outRefundNo(String outRefundNo) {
            instance.setOutRefundNo(outRefundNo);
            return this;
        }

        public Builder totalFee(Integer totalFee) {
            instance.setTotalFee(totalFee);
            return this;
        }

        public Builder refundFee(Integer refundFee) {
            instance.setRefundFee(refundFee);
            return this;
        }

        public Builder refundFeeType(String refundFeeType) {
            instance.setRefundFeeType(refundFeeType);
            return this;
        }

        public Builder refundDesc(String refundDesc) {
            instance.setRefundDesc(refundDesc);
            return this;
        }

        public Builder refundAccount(String refundAccount) {
            instance.setRefundAccount(refundAccount);
            return this;
        }

        public Builder tradeType(String tradeType) {
            instance.setTradeType(tradeType);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public RefundModel build() {
            RefundModel refundModel = new RefundModel();
            refundModel.setTenantId(instance.getTenantId());
            refundModel.setBranchId(instance.getBranchId());
            refundModel.setTransactionId(instance.getTransactionId());
            refundModel.setOutTradeNo(instance.getOutTradeNo());
            refundModel.setOutRefundNo(instance.getOutRefundNo());
            refundModel.setTotalFee(instance.getTotalFee());
            refundModel.setRefundFee(instance.getRefundFee());
            refundModel.setRefundFeeType(instance.getRefundFeeType());
            refundModel.setRefundDesc(instance.getRefundDesc());
            refundModel.setRefundAccount(instance.getRefundAccount());
            refundModel.setTradeType(instance.getTradeType());
            refundModel.setTopic(instance.getTopic());
            return refundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}