package build.dream.common.models.data;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class UpdateShopModel extends DadaBasicModel {
    /**
     * 门店编码
     */
    @NotNull
    @JsonProperty(value = "origin_shop_id")
    private String originShopId;

    /**
     * 新的门店编码
     */
    @JsonProperty(value = "new_shop_id")
    private String newShopId;

    /**
     * 门店名称
     */
    @JsonProperty(value = "station_name")
    private String stationName;

    /**
     * 业务类型(食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5)
     */
    @InList(value = {"1", "2", "3", "8", "9", "13", "19", "20", "21", "24", "25", "26", "27", "28", "29", "5"})
    private Integer business;

    /**
     * 城市名称(如,上海)
     */
    @JsonProperty(value = "city_name")
    private String cityName;

    /**
     * 区域名称(如,浦东新区)
     */
    @JsonProperty(value = "area_name")
    private String areaName;

    /**
     * 门店地址
     */
    @JsonProperty(value = "station_address")
    private String stationAddress;

    /**
     * 门店经度
     */
    private Double lng;

    /**
     * 门店纬度
     */
    private Double lat;

    /**
     * 联系人姓名
     */
    @JsonProperty(value = "contact_name")
    private String contactName;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 门店状态（1-门店激活，0-门店下线）
     */
    private Integer status;

    public String getOriginShopId() {
        return originShopId;
    }

    public void setOriginShopId(String originShopId) {
        this.originShopId = originShopId;
    }

    public String getNewShopId() {
        return newShopId;
    }

    public void setNewShopId(String newShopId) {
        this.newShopId = newShopId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, UpdateShopModel> {
        public Builder originShopId(String originShopId) {
            instance.setOriginShopId(originShopId);
            return this;
        }

        public Builder newShopId(String newShopId) {
            instance.setNewShopId(newShopId);
            return this;
        }

        public Builder stationName(String stationName) {
            instance.setStationName(stationName);
            return this;
        }

        public Builder business(Integer business) {
            instance.setBusiness(business);
            return this;
        }

        public Builder cityName(String cityName) {
            instance.setCityName(cityName);
            return this;
        }

        public Builder areaName(String areaName) {
            instance.setAreaName(areaName);
            return this;
        }

        public Builder stationAddress(String stationAddress) {
            instance.setStationAddress(stationAddress);
            return this;
        }

        public Builder lng(Double lng) {
            instance.setLng(lng);
            return this;
        }

        public Builder lat(Double lat) {
            instance.setLat(lat);
            return this;
        }

        public Builder contactName(String contactName) {
            instance.setContactName(contactName);
            return this;
        }

        public Builder phone(String phone) {
            instance.setPhone(phone);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        @Override
        public UpdateShopModel build() {
            UpdateShopModel updateShopModel = super.build();
            updateShopModel.setOriginShopId(instance.getOriginShopId());
            updateShopModel.setNewShopId(instance.getNewShopId());
            updateShopModel.setStationName(instance.getStationName());
            updateShopModel.setBusiness(instance.getBusiness());
            updateShopModel.setCityName(instance.getCityName());
            updateShopModel.setAreaName(instance.getAreaName());
            updateShopModel.setStationAddress(instance.getStationAddress());
            updateShopModel.setLng(instance.getLng());
            updateShopModel.setLat(instance.getLat());
            updateShopModel.setContactName(instance.getContactName());
            updateShopModel.setPhone(instance.getPhone());
            updateShopModel.setStatus(instance.getStatus());
            return updateShopModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
