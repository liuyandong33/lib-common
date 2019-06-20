package build.dream.common.models.data;

import build.dream.common.constraints.InList;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AddShopModel extends DadaBasicModel {
    /**
     * 门店名称
     */
    @NotNull
    @JsonProperty(value = "station_name")
    private String stationName;

    /**
     * 业务类型(食品小吃-1,饮料-2,鲜花-3,文印票务-8,便利店-9,水果生鲜-13,同城电商-19, 医药-20,蛋糕-21,酒品-24,小商品市场-25,服装-26,汽修零配-27,数码-28,小龙虾-29, 其他-5)
     */
    @NotNull
    @InList(value = {"1", "2", "3", "8", "9", "13", "19", "20", "21", "24", "25", "26", "27", "28", "29", "5"})
    private Integer business;

    /**
     * 城市名称(如,上海)
     */
    @NotNull
    @JsonProperty(value = "city_name")
    private String cityName;

    /**
     * 区域名称(如,浦东新区)
     */
    @NotNull
    @JsonProperty(value = "area_name")
    private String areaName;

    /**
     * 门店地址
     */
    @NotNull
    @JsonProperty(value = "station_address")
    private String stationAddress;

    /**
     * 门店经度
     */
    @NotNull
    private Double lng;

    /**
     * 门店纬度
     */
    @NotNull
    private Double lat;

    /**
     * 联系人姓名
     */
    @NotNull
    @JsonProperty(value = "contact_name")
    private String contactName;

    /**
     * 联系人电话
     */
    @NotNull
    private String phone;

    /**
     * 门店编码,可自定义,但必须唯一;若不填写,则系统自动生成
     */
    @JsonProperty(value = "origin_shop_id")
    private String originShopId;

    /**
     * 联系人身份证
     */
    @JsonProperty(value = "id_card")
    private String idCard;

    /**
     * 达达商家app账号(若不需要登陆app,则不用设置)
     */
    private String username;

    /**
     * 达达商家app密码(若不需要登陆app,则不用设置)
     */
    private String password;

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

    public String getOriginShopId() {
        return originShopId;
    }

    public void setOriginShopId(String originShopId) {
        this.originShopId = originShopId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder extends DadaBasicModel.Builder<Builder, AddShopModel> {
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

        public Builder originShopId(String originShopId) {
            instance.setOriginShopId(originShopId);
            return this;
        }

        public Builder idCard(String idCard) {
            instance.setIdCard(idCard);
            return this;
        }

        public Builder username(String username) {
            instance.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        @Override
        public AddShopModel build() {
            AddShopModel addShopModel = super.build();
            addShopModel.setStationName(instance.getStationName());
            addShopModel.setBusiness(instance.getBusiness());
            addShopModel.setCityName(instance.getCityName());
            addShopModel.setAreaName(instance.getAreaName());
            addShopModel.setStationAddress(instance.getStationAddress());
            addShopModel.setLng(instance.getLng());
            addShopModel.setLat(instance.getLat());
            addShopModel.setContactName(instance.getContactName());
            addShopModel.setPhone(instance.getPhone());
            addShopModel.setOriginShopId(instance.getOriginShopId());
            addShopModel.setIdCard(instance.getIdCard());
            addShopModel.setUsername(instance.getUsername());
            addShopModel.setPassword(instance.getPassword());
            return addShopModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
