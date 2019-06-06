package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class KoubeiMarketingDataTradeHabbitQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "biz_date")
    private String bizDate;

    @Length(max = 255)
    @JsonProperty(value = "store_ids")
    private String storeIds;

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(String storeIds) {
        this.storeIds = storeIds;
    }

    public static class Builder  extends AlipayBasicModel.Builder<Builder>{
        private final KoubeiMarketingDataTradeHabbitQueryModel instance = new KoubeiMarketingDataTradeHabbitQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder bizDate(String bizDate) {
            instance.setBizDate(bizDate);
            return this;
        }

        public Builder storeIds(String storeIds) {
            instance.setStoreIds(storeIds);
            return this;
        }

        public KoubeiMarketingDataTradeHabbitQueryModel build() {
            KoubeiMarketingDataTradeHabbitQueryModel koubeiMarketingDataTradeHabbitQueryModel = new KoubeiMarketingDataTradeHabbitQueryModel();
            build(koubeiMarketingDataTradeHabbitQueryModel);
            koubeiMarketingDataTradeHabbitQueryModel.setBizDate(instance.getBizDate());
            koubeiMarketingDataTradeHabbitQueryModel.setStoreIds(instance.getStoreIds());
            return koubeiMarketingDataTradeHabbitQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
