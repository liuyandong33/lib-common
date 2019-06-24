package build.dream.common.models.anubis;

import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ChainStoreDeliveryQueryModel extends AnubisBasicModel {
    private static final Integer[] POSITION_SOURCES = {0, 1, 2, 3};
    @NotNull
    @Length(max = 32)
    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    private String chainStoreCode;

    @NotNull
    @SerializedName(value = "position_source", alternate = "positionSource")
    private Integer positionSource;

    @NotNull
    @SerializedName(value = "receiver_longitude", alternate = "receiverLongitude")
    private Double receiverLongitude;

    @NotNull
    @SerializedName(value = "receiver_latitude", alternate = "receiverLatitude")
    private Double receiverLatitude;

    public String getChainStoreCode() {
        return chainStoreCode;
    }

    public void setChainStoreCode(String chainStoreCode) {
        this.chainStoreCode = chainStoreCode;
    }

    public Integer getPositionSource() {
        return positionSource;
    }

    public void setPositionSource(Integer positionSource) {
        this.positionSource = positionSource;
    }

    public Double getReceiverLongitude() {
        return receiverLongitude;
    }

    public void setReceiverLongitude(Double receiverLongitude) {
        this.receiverLongitude = receiverLongitude;
    }

    public Double getReceiverLatitude() {
        return receiverLatitude;
    }

    public void setReceiverLatitude(Double receiverLatitude) {
        this.receiverLatitude = receiverLatitude;
    }

    @Override
    public boolean validate() {
        return super.validate() && ArrayUtils.contains(POSITION_SOURCES, positionSource);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(POSITION_SOURCES, positionSource, "positionSource");
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, ChainStoreDeliveryQueryModel> {
        public Builder chainStoreCode(String chainStoreCode) {
            instance.setChainStoreCode(chainStoreCode);
            return this;
        }

        public Builder positionSource(Integer positionSource) {
            instance.setPositionSource(positionSource);
            return this;
        }

        public Builder receiverLongitude(Double receiverLongitude) {
            instance.setReceiverLongitude(receiverLongitude);
            return this;
        }

        public Builder receiverLatitude(Double receiverLatitude) {
            instance.setReceiverLatitude(receiverLatitude);
            return this;
        }

        @Override
        public ChainStoreDeliveryQueryModel build() {
            ChainStoreDeliveryQueryModel chainStoreDeliveryQueryModel = super.build();
            chainStoreDeliveryQueryModel.setChainStoreCode(instance.getChainStoreCode());
            chainStoreDeliveryQueryModel.setPositionSource(instance.getPositionSource());
            chainStoreDeliveryQueryModel.setReceiverLongitude(instance.getReceiverLongitude());
            chainStoreDeliveryQueryModel.setReceiverLatitude(instance.getReceiverLatitude());
            return chainStoreDeliveryQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
