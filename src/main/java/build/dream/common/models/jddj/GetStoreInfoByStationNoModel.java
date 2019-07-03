package build.dream.common.models.jddj;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class GetStoreInfoByStationNoModel extends JDDJBasicModel {
    @NotNull
    @JsonProperty(value = "StoreNo")
    private String storeNo;

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetStoreInfoByStationNoModel> {
        public Builder storeNo(String storeNo) {
            instance.setStoreNo(storeNo);
            return this;
        }

        @Override
        public GetStoreInfoByStationNoModel build() {
            GetStoreInfoByStationNoModel getStoreInfoByStationNoModel = super.build();
            getStoreInfoByStationNoModel.setStoreNo(instance.getStoreNo());
            return getStoreInfoByStationNoModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
