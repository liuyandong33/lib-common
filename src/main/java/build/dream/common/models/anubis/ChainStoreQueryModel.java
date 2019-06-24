package build.dream.common.models.anubis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChainStoreQueryModel extends AnubisBasicModel {
    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    @JsonProperty(value = "chain_store_code")
    private List<String> chainStoreCodes;

    @SerializedName(value = "chain_store_name", alternate = "chainStoreName")
    @JsonProperty(value = "chain_store_name")
    private String chainStoreName;

    public List<String> getChainStoreCodes() {
        return chainStoreCodes;
    }

    public void setChainStoreCodes(List<String> chainStoreCodes) {
        this.chainStoreCodes = chainStoreCodes;
    }

    public String getChainStoreName() {
        return chainStoreName;
    }

    public void setChainStoreName(String chainStoreName) {
        this.chainStoreName = chainStoreName;
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, ChainStoreQueryModel> {
        public Builder chainStoreCodes(List<String> chainStoreCodes) {
            instance.setChainStoreCodes(chainStoreCodes);
            return this;
        }

        public Builder chainStoreName(String chainStoreName) {
            instance.setChainStoreName(chainStoreName);
            return this;
        }

        @Override
        public ChainStoreQueryModel build() {
            ChainStoreQueryModel chainStoreQueryModel = super.build();
            chainStoreQueryModel.setChainStoreCodes(instance.getChainStoreCodes());
            chainStoreQueryModel.setChainStoreName(instance.getChainStoreName());
            return chainStoreQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
