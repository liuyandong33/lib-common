package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class GetDeliveryRangeByStationNoModel extends JDDJBasicModel {
    /**
     * 到家门店编码
     */
    @NotNull
    private String stationNo;

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetDeliveryRangeByStationNoModel> {
        public Builder stationNo(String stationNo) {
            instance.setStationNo(stationNo);
            return this;
        }

        @Override
        public GetDeliveryRangeByStationNoModel build() {
            GetDeliveryRangeByStationNoModel getDeliveryRangeByStationNoModel = super.build();
            getDeliveryRangeByStationNoModel.setStationNo(instance.getStationNo());
            return getDeliveryRangeByStationNoModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
