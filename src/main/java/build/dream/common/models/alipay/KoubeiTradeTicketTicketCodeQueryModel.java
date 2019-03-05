package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiTradeTicketTicketCodeQueryModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String tenantId;

    @NotNull
    @JsonIgnore
    private String branchId;

    @NotNull
    @Length(max = 12)
    private String ticketCode;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "shop_id")
    private String shopId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchId() {
        return branchId;
    }

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
            koubeiTradeTicketTicketCodeQueryModel.setTicketCode(instance.getTicketCode());
            koubeiTradeTicketTicketCodeQueryModel.setShopId(instance.getShopId());
            return koubeiTradeTicketTicketCodeQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
