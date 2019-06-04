package build.dream.common.models.beeleme;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderPartRefundModel extends BeElemeBasicModel {
    @SerializedName(value = "order_id", alternate = "orderId")
    @JsonProperty(value = "order_id")
    @NotNull
    private String orderId;

    @NotEmpty
    private List<Product> products;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        for (Product product : products) {
            ApplicationHandler.isTrue(product.validate(), "products");
        }
    }

    public static class Product extends BasicModel {
        @SerializedName(value = "sku_id", alternate = "skuId")
        @JsonProperty(value = "sku_id")
        private String skuId;

        private String upc;

        @SerializedName(value = "custom_sku_id", alternate = "customSkuId")
        @JsonProperty(value = "custom_sku_id")
        private String customSkuId;

        @NotNull
        private String number;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public String getUpc() {
            return upc;
        }

        public void setUpc(String upc) {
            this.upc = upc;
        }

        public String getCustomSkuId() {
            return customSkuId;
        }

        public void setCustomSkuId(String customSkuId) {
            this.customSkuId = customSkuId;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static class Builder {
        private final OrderPartRefundModel instance = new OrderPartRefundModel();

        public Builder source(String source) {
            instance.setSource(source);
            return this;
        }

        public Builder encrypt(String encrypt) {
            instance.setEncrypt(encrypt);
            return this;
        }

        public Builder fields(String fields) {
            instance.setFields(fields);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder products(List<Product> products) {
            instance.setProducts(products);
            return this;
        }

        public OrderPartRefundModel build() {
            OrderPartRefundModel orderPartRefundModel = new OrderPartRefundModel();
            orderPartRefundModel.setSource(instance.getSource());
            orderPartRefundModel.setEncrypt(instance.getEncrypt());
            orderPartRefundModel.setFields(instance.getFields());
            orderPartRefundModel.setOrderId(instance.getOrderId());
            orderPartRefundModel.setProducts(instance.getProducts());
            return orderPartRefundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
