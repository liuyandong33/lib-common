package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiTradeTicketTicketCodeSyncModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "request_id")
    private String requestId;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "ticket_code")
    private String ticketCode;

    @NotNull
    @Length(max = 4)
    private String quantity;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "order_no")
    private String orderNo;

    @InList(value = {"INTERNAL_CODE", "EXTERNAL_CODE"})
    @JsonProperty(value = "code_type")
    private String codeType;

    @Length(min = 19, max = 19)
    @JsonProperty(value = "gmt_biz")
    private String gmtBiz;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getGmtBiz() {
        return gmtBiz;
    }

    public void setGmtBiz(String gmtBiz) {
        this.gmtBiz = gmtBiz;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final KoubeiTradeTicketTicketCodeSyncModel instance = new KoubeiTradeTicketTicketCodeSyncModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder requestId(String requestId) {
            instance.setRequestId(requestId);
            return this;
        }

        public Builder ticketCode(String ticketCode) {
            instance.setTicketCode(ticketCode);
            return this;
        }

        public Builder quantity(String quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder orderNo(String orderNo) {
            instance.setOrderNo(orderNo);
            return this;
        }

        public Builder codeType(String codeType) {
            instance.setCodeType(codeType);
            return this;
        }

        public Builder gmtBiz(String gmtBiz) {
            instance.setGmtBiz(gmtBiz);
            return this;
        }

        public KoubeiTradeTicketTicketCodeSyncModel build() {
            KoubeiTradeTicketTicketCodeSyncModel koubeiTradeTicketTicketCodeSyncModel = new KoubeiTradeTicketTicketCodeSyncModel();
            build(koubeiTradeTicketTicketCodeSyncModel);
            koubeiTradeTicketTicketCodeSyncModel.setRequestId(instance.getRequestId());
            koubeiTradeTicketTicketCodeSyncModel.setTicketCode(instance.getTicketCode());
            koubeiTradeTicketTicketCodeSyncModel.setQuantity(instance.getQuantity());
            koubeiTradeTicketTicketCodeSyncModel.setOrderNo(instance.getOrderNo());
            koubeiTradeTicketTicketCodeSyncModel.setCodeType(instance.getCodeType());
            koubeiTradeTicketTicketCodeSyncModel.setGmtBiz(instance.getGmtBiz());
            return koubeiTradeTicketTicketCodeSyncModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
