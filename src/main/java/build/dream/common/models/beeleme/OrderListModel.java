package build.dream.common.models.beeleme;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class OrderListModel extends BeElemeBasicModel {
    @SerializedName(value = "start_time", alternate = "startTime")
    @JsonProperty(value = "start_time")
    private Long startTime;

    @SerializedName(value = "end_time", alternate = "endTime")
    @JsonProperty(value = "end_time")
    private Long endTime;

    private String status;

    private Integer page;

    @SerializedName(value = "shop_id", alternate = "shopId")
    @JsonProperty(value = "shop_id")
    private String shopId;

    @SerializedName(value = "baidu_shop_id", alternate = "baiduShopId")
    @JsonProperty(value = "baidu_shop_id")
    private String baiduShopId;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBaiduShopId() {
        return baiduShopId;
    }

    public void setBaiduShopId(String baiduShopId) {
        this.baiduShopId = baiduShopId;
    }

    public static class Builder {
        private final OrderListModel instance = new OrderListModel();

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

        public Builder startTime(Long startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Long endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder page(Integer page) {
            instance.setPage(page);
            return this;
        }

        public Builder shopId(String shopId) {
            instance.setShopId(shopId);
            return this;
        }

        public Builder baiduShopId(String baiduShopId) {
            instance.setBaiduShopId(baiduShopId);
            return this;
        }

        public OrderListModel build() {
            OrderListModel orderListModel = new OrderListModel();
            orderListModel.setSource(instance.getSource());
            orderListModel.setEncrypt(instance.getEncrypt());
            orderListModel.setFields(instance.getFields());
            orderListModel.setStartTime(instance.getStartTime());
            orderListModel.setEndTime(instance.getEndTime());
            orderListModel.setStatus(instance.getStatus());
            orderListModel.setPage(instance.getPage());
            orderListModel.setShopId(instance.getShopId());
            orderListModel.setBaiduShopId(instance.getBaiduShopId());
            return orderListModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
