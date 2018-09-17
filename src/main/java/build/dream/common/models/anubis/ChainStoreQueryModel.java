package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChainStoreQueryModel extends BasicModel {
    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    private List<String> chainStoreCode;

    @SerializedName(value = "chain_store_name", alternate = "chainStoreName")
    private String chainStoreName;

    public List<String> getChainStoreCode() {
        return chainStoreCode;
    }

    public void setChainStoreCode(List<String> chainStoreCode) {
        this.chainStoreCode = chainStoreCode;
    }

    public String getChainStoreName() {
        return chainStoreName;
    }

    public void setChainStoreName(String chainStoreName) {
        this.chainStoreName = chainStoreName;
    }
}
