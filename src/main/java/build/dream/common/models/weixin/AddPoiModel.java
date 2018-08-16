package build.dream.common.models.weixin;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AddPoiModel extends BasicModel {
    @SerializedName(value = "base_info", alternate = "baseInfoModel")
    private BaseInfoModel baseInfoModel;

    public BaseInfoModel getBaseInfoModel() {
        return baseInfoModel;
    }

    public void setBaseInfoModel(BaseInfoModel baseInfoModel) {
        this.baseInfoModel = baseInfoModel;
    }

    public static class BaseInfoModel extends BasicModel {
        private String sid;

        @NotNull
        @Length(max = 30)
        @SerializedName(value = "business_name", alternate = "businessName")
        private String businessName;

        @NotNull
        @Length(max = 20)
        @SerializedName(value = "branch_name", alternate = "branchName")
        private String branch_name;

        @NotNull
        @Length(max = 10)
        private String province;

        @NotNull
        @Length(max = 10)
        private String city;

        @NotNull
        @Length(max = 10)
        private String district;

        @NotNull
        @Length(max = 80)
        private String address;

        @NotNull
        @Length(max = 53)
        private String telephone;

        @NotNull
        private List<String> categories;

        @NotNull
        @InList(value = {"1", "2", "3", "4", "5"})
        @SerializedName(value = "offset_type", alternate = "offsetType")
        private String offsetType;

        @NotNull
        private String longitude;

        @NotNull
        private String latitude;

        @SerializedName(value = "photo_list", alternate = "photoList")
        private List<String> photoList;

        @Length(max = 200)
        private String recommend;

        @Length(max = 200)
        private String special;

        @Length(max = 300)
        private String introduction;

        @SerializedName(value = "open_time", alternate = "openTime")
        private String openTime;

        @Min(value = 1)
        @SerializedName(value = "avg_price", alternate = "avgPrice")
        private Integer avgPrice;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBranch_name() {
            return branch_name;
        }

        public void setBranch_name(String branch_name) {
            this.branch_name = branch_name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public String getOffsetType() {
            return offsetType;
        }

        public void setOffsetType(String offsetType) {
            this.offsetType = offsetType;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public List<String> getPhotoList() {
            return photoList;
        }

        public void setPhotoList(List<String> photoList) {
            this.photoList = photoList;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public String getSpecial() {
            return special;
        }

        public void setSpecial(String special) {
            this.special = special;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public Integer getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(Integer avgPrice) {
            this.avgPrice = avgPrice;
        }
    }
}
