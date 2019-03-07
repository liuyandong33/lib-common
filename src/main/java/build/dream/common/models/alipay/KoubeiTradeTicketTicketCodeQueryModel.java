package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiTradeTicketTicketCodeQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 12)
    private String ticketCode;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "shop_id")
    private String shopId;

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public static class Builder {
        private final KoubeiTradeTicketTicketCodeQueryModel instance = new KoubeiTradeTicketTicketCodeQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder ticketCode(String ticketCode) {
            instance.setTicketCode(ticketCode);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public KoubeiTradeTicketTicketCodeQueryModel build() {
            KoubeiTradeTicketTicketCodeQueryModel koubeiTradeTicketTicketCodeQueryModel = new KoubeiTradeTicketTicketCodeQueryModel();
            koubeiTradeTicketTicketCodeQueryModel.setTenantId(instance.getTenantId());
            koubeiTradeTicketTicketCodeQueryModel.setBranchId(instance.getBranchId());
            koubeiTradeTicketTicketCodeQueryModel.setReturnUrl(instance.getReturnUrl());
            koubeiTradeTicketTicketCodeQueryModel.setNotifyUrl(instance.getNotifyUrl());
            koubeiTradeTicketTicketCodeQueryModel.setAuthToken(instance.getAuthToken());
            koubeiTradeTicketTicketCodeQueryModel.setTicketCode(instance.getTicketCode());
            koubeiTradeTicketTicketCodeQueryModel.setShopId(instance.getShopId());
            return koubeiTradeTicketTicketCodeQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
