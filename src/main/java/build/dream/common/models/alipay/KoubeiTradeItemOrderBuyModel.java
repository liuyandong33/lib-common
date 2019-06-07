package build.dream.common.models.alipay;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class KoubeiTradeItemOrderBuyModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "out_order_no")
    private String outOrderNo;

    @NotNull
    @Length(max = 256)
    private String subject;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "biz_product")
    private String bizProduct;

    @NotNull
    @Length(max = 32)
    @JsonProperty(value = "biz_scene")
    private String bizScene;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "shop_id")
    private String shopId;

    @NotNull
    @Length(max = 64)
    @JsonProperty(value = "buyer_id")
    private String buyerId;

    @Length(max = 6)
    private String timeout;

    @NotNull
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999999")
    @JsonProperty(value = "total_amount")
    private BigDecimal totalAmount;

    @Length(max = 512)
    @JsonProperty(value = "promo_params")
    private String promoParams;

    @NotEmpty
    @JsonProperty(value = "item_order_details")
    private List<ItemOrderDetail> itemOrderDetails;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBizProduct() {
        return bizProduct;
    }

    public void setBizProduct(String bizProduct) {
        this.bizProduct = bizProduct;
    }

    public String getBizScene() {
        return bizScene;
    }

    public void setBizScene(String bizScene) {
        this.bizScene = bizScene;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPromoParams() {
        return promoParams;
    }

    public void setPromoParams(String promoParams) {
        this.promoParams = promoParams;
    }

    public List<ItemOrderDetail> getItemOrderDetails() {
        return itemOrderDetails;
    }

    public void setItemOrderDetails(List<ItemOrderDetail> itemOrderDetails) {
        this.itemOrderDetails = itemOrderDetails;
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder, KoubeiTradeItemOrderBuyModel> {
        public Builder outOrderNo(String outOrderNo) {
            instance.setOutOrderNo(outOrderNo);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder bizProduct(String bizProduct) {
            instance.setBizProduct(bizProduct);
            return this;
        }

        public Builder bizScene(String bizScene) {
            instance.setBizScene(bizScene);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder buyerId(String buyerId) {
            instance.setBuyerId(buyerId);
            return this;
        }

        public Builder timeout(String timeout) {
            instance.setTimeout(timeout);
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder promoParams(String promoParams) {
            instance.setPromoParams(promoParams);
            return this;
        }

        public Builder itemOrderDetails(List<ItemOrderDetail> itemOrderDetails) {
            instance.setItemOrderDetails(itemOrderDetails);
            return this;
        }

        @Override
        public KoubeiTradeItemOrderBuyModel build() {
            KoubeiTradeItemOrderBuyModel koubeiTradeItemOrderBuyModel = super.build();
            koubeiTradeItemOrderBuyModel.setOutOrderNo(instance.getOutOrderNo());
            koubeiTradeItemOrderBuyModel.setSubject(instance.getSubject());
            koubeiTradeItemOrderBuyModel.setBizProduct(instance.getBizProduct());
            koubeiTradeItemOrderBuyModel.setBizScene(instance.getBizScene());
            koubeiTradeItemOrderBuyModel.setShopId(instance.getShopId());
            koubeiTradeItemOrderBuyModel.setBuyerId(instance.getBuyerId());
            koubeiTradeItemOrderBuyModel.setTimeout(instance.getTimeout());
            koubeiTradeItemOrderBuyModel.setTotalAmount(instance.getTotalAmount());
            koubeiTradeItemOrderBuyModel.setPromoParams(instance.getPromoParams());
            koubeiTradeItemOrderBuyModel.setItemOrderDetails(instance.getItemOrderDetails());
            return koubeiTradeItemOrderBuyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class ItemOrderDetail extends BasicModel {
        @NotNull
        @Length(max = 64)
        @JsonProperty(value = "sku_id")
        private String skuId;

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "999999999")
        @JsonProperty(value = "original_price")
        private BigDecimal originalPrice;

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "999999999")
        private BigDecimal price;

        @NotNull
        @Min(value = 1)
        @Max(value = 999999)
        private Integer quantity;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public BigDecimal getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(BigDecimal originalPrice) {
            this.originalPrice = originalPrice;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
