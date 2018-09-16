package build.dream.common.models.anubis;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderModel extends BasicModel {
    @Length(max = 255)
    @SerializedName(value = "partner_remark", alternate = "partnerRemark")
    private String partnerRemark;

    @NotNull
    @Length(max = 128)
    @SerializedName(value = "partner_order_code", alternate = "partnerOrderCode")
    private String partnerOrderCode;

    @NotNull
    @Length(max = 255)
    @SerializedName(value = "notify_url", alternate = "notifyUrl")
    private String notifyUrl;

    @NotNull
    @SerializedName(value = "order_type", alternate = "orderType")
    private Integer orderType;

    @SerializedName(value = "chain_store_code", alternate = "chainStoreCode")
    private String chainStoreCode;

    @NotNull
    private TransportInfo transportInfo;

    @SerializedName(value = "order_add_time", alternate = "orderAddTime")
    private Long orderAddTime;

    @NotNull
    @SerializedName(value = "order_total_amount", alternate = "orderTotalAmount")
    private BigDecimal orderTotalAmount;

    @SerializedName(value = "order_actual_amount", alternate = "orderActualAmount")
    private BigDecimal orderActualAmount;

    public static class TransportInfo extends BasicModel {
        private static final Integer[] POSITION_SOURCES = {1, 2, 3};
        @Length(max = 32)
        @SerializedName(value = "transport_id", alternate = "transportId")
        private String transportId;

        @NotNull
        @Length(max = 32)
        @SerializedName(value = "transport_name", alternate = "transportName")
        private String transportName;

        @NotNull
        @Length(max = 255)
        @SerializedName(value = "transport_address", alternate = "transportAddress")
        private String transportAddress;

        @NotNull
        @SerializedName(value = "transport_longitude", alternate = "transportLongitude")
        private Double transportLongitude;

        @NotNull
        @SerializedName(value = "transport_latitude", alternate = "transportLatitude")
        private Double transportLatitude;

        @NotNull
        @SerializedName(value = "position_source", alternate = "positionSource")
        private Integer positionSource;

        @NotNull
        @Length(max = 16)
        @SerializedName(value = "transport_tel", alternate = "transportTel")
        private String transportTel;

        @Length(max = 255)
        @SerializedName(value = "transport_remark", alternate = "transportRemark")
        private String transportRemark;

        public String getTransportId() {
            return transportId;
        }

        public void setTransportId(String transportId) {
            this.transportId = transportId;
        }


        public String getTransportName() {
            return transportName;
        }

        public void setTransportName(String transportName) {
            this.transportName = transportName;
        }


        public String getTransportAddress() {
            return transportAddress;
        }

        public void setTransportAddress(String transportAddress) {
            this.transportAddress = transportAddress;
        }


        public Double getTransportLongitude() {
            return transportLongitude;
        }

        public void setTransportLongitude(Double transportLongitude) {
            this.transportLongitude = transportLongitude;
        }


        public Double getTransportLatitude() {
            return transportLatitude;
        }

        public void setTransportLatitude(Double transportLatitude) {
            this.transportLatitude = transportLatitude;
        }


        public Integer getPositionSource() {
            return positionSource;
        }

        public void setPositionSource(Integer positionSource) {
            this.positionSource = positionSource;
        }


        public String getTransportTel() {
            return transportTel;
        }

        public void setTransportTel(String transportTel) {
            this.transportTel = transportTel;
        }

        public String getTransportRemark() {
            return transportRemark;
        }

        public void setTransportRemark(String transportRemark) {
            this.transportRemark = transportRemark;
        }

        @Override
        public boolean validate() {
            return super.validate() && ArrayUtils.contains(POSITION_SOURCES, positionSource);
        }

        @Override
        public void validateAndThrow() {
            super.validateAndThrow();
            Validate.isTrue(ArrayUtils.contains(POSITION_SOURCES, positionSource));
        }
    }
}
