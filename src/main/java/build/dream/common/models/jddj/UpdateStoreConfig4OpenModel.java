package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class UpdateStoreConfig4OpenModel extends JDDJBasicModel {
    /**
     * 到家门店编码
     */
    @NotNull
    private String stationNo;

    /**
     * 是否自动接单。0:是 1:否
     */
    @NotNull
    private Integer isAutoOrder;

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public Integer getIsAutoOrder() {
        return isAutoOrder;
    }

    public void setIsAutoOrder(Integer isAutoOrder) {
        this.isAutoOrder = isAutoOrder;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateStoreConfig4OpenModel> {
        public Builder stationNo(String stationNo) {
            instance.setStationNo(stationNo);
            return this;
        }

        public Builder isAutoOrder(Integer isAutoOrder) {
            instance.setIsAutoOrder(isAutoOrder);
            return this;
        }

        @Override
        public UpdateStoreConfig4OpenModel build() {
            UpdateStoreConfig4OpenModel updateStoreConfig4OpenModel = super.build();
            updateStoreConfig4OpenModel.setStationNo(instance.getStationNo());
            updateStoreConfig4OpenModel.setIsAutoOrder(instance.getIsAutoOrder());
            return updateStoreConfig4OpenModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
