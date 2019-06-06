package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiTradeOrderPreCreateModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "request_id")
    private String requestId;

    @Length(max = 64)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @Length(max = 64)
    @JsonProperty(value = "shop_id")
    private String shopId;

    @InList(value = {"POST_ORDER_PAY"})
    @JsonProperty(value = "biz_type")
    private String bizType;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Override
    public boolean validate() {
        boolean isTrue = super.validate();
        if (!isTrue) {
            return false;
        }

        if ("POST_ORDER_PAY".equals(bizType)) {
            return StringUtils.isNotBlank(outOrderNo) && StringUtils.isNotBlank(shopId);
        }
        return true;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if ("POST_ORDER_PAY".equals(bizType)) {
            ApplicationHandler.notBlank(outOrderNo, "outOrderNo");
            ApplicationHandler.notBlank(shopId, "shopId");
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiTradeOrderPreCreateModel instance = new KoubeiTradeOrderPreCreateModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public KoubeiTradeOrderPreCreateModel build() {
            KoubeiTradeOrderPreCreateModel koubeiTradeOrderPreCreateModel = new KoubeiTradeOrderPreCreateModel();
            build(koubeiTradeOrderPreCreateModel);
            koubeiTradeOrderPreCreateModel.setRequestId(instance.getRequestId());
            koubeiTradeOrderPreCreateModel.setOutOrderNo(instance.getOutOrderNo());
            koubeiTradeOrderPreCreateModel.setShopId(instance.getShopId());
            koubeiTradeOrderPreCreateModel.setBizType(instance.getBizType());
            return koubeiTradeOrderPreCreateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
