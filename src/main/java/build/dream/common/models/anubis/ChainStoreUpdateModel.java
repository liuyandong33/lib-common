package build.dream.common.models.anubis;

import build.dream.common.utils.ApplicationHandler;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ChainStoreUpdateModel extends AnubisBasicModel {
    private static final Integer[] POSITION_SOURCES = {1, 2, 3};
    private static final Integer[] SERVICE_CODES = {1, 2, 3};
    @NotNull
    @Length(max = 32)
    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    private String chainStoreCode;

    @NotNull
    @Length(max = 32)
    @SerializedName(value = "chain_store_name", alternate = "chainStoreName")
    private String chainStoreName;

    @NotNull
    @SerializedName(value = "contact_phone", alternate = "contactPhone")
    private String contactPhone;

    @NotNull
    @Length(max = 64)
    private String address;

    @SerializedName(value = "position_source", alternate = "positionSource")
    private Integer positionSource;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @SerializedName(value = "service_code", alternate = "serviceCode")
    private Integer serviceCode;

    public String getChainStoreCode() {
        return chainStoreCode;
    }

    public void setChainStoreCode(String chainStoreCode) {
        this.chainStoreCode = chainStoreCode;
    }

    public String getChainStoreName() {
        return chainStoreName;
    }

    public void setChainStoreName(String chainStoreName) {
        this.chainStoreName = chainStoreName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPositionSource() {
        return positionSource;
    }

    public void setPositionSource(Integer positionSource) {
        this.positionSource = positionSource;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public boolean validate() {
        return super.validate() && ArrayUtils.contains(POSITION_SOURCES, positionSource) && ArrayUtils.contains(SERVICE_CODES, serviceCode);
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        ApplicationHandler.inArray(POSITION_SOURCES, positionSource, "positionSource");
        ApplicationHandler.inArray(SERVICE_CODES, serviceCode, "serviceCode");
    }

    public static class Builder extends AnubisBasicModel.Builder<Builder, ChainStoreUpdateModel> {
        public Builder chainStoreCode(String chainStoreCode) {
            instance.setChainStoreCode(chainStoreCode);
            return this;
        }

        public Builder chainStoreName(String chainStoreName) {
            instance.setChainStoreName(chainStoreName);
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            instance.setContactPhone(contactPhone);
            return this;
        }

        public Builder positionSource(Integer positionSource) {
            instance.setPositionSource(positionSource);
            return this;
        }

        public Builder longitude(Double longitude) {
            instance.setLongitude(longitude);
            return this;
        }

        public Builder latitude(Double latitude) {
            instance.setLatitude(latitude);
            return this;
        }

        public Builder serviceCode(Integer serviceCode) {
            instance.setServiceCode(serviceCode);
            return this;
        }

        @Override
        public ChainStoreUpdateModel build() {
            ChainStoreUpdateModel chainStoreUpdateModel = super.build();
            chainStoreUpdateModel.setChainStoreCode(instance.getChainStoreCode());
            chainStoreUpdateModel.setChainStoreName(instance.getChainStoreName());
            chainStoreUpdateModel.setContactPhone(instance.getContactPhone());
            chainStoreUpdateModel.setPositionSource(instance.getPositionSource());
            chainStoreUpdateModel.setLongitude(instance.getLongitude());
            chainStoreUpdateModel.setLatitude(instance.getLatitude());
            chainStoreUpdateModel.setServiceCode(instance.getServiceCode());
            return chainStoreUpdateModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
