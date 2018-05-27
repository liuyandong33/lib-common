package build.dream.common.models.jingdong;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.GsonUtils;
import org.hibernate.validator.constraints.Length;

public class ReceiverInfo extends BasicModel {
    @Length(max = 100)
    private String name;

    @Length(max = 500)
    private String address;

    @Length(max = 30)
    private String mobile;

    @Length(max = 20)
    private String phone;

    @Length(max = 100)
    private String email;

    @Length(max = 30)
    private String province;

    @Length(max = 30)
    private String city;

    @Length(max = 30)
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return GsonUtils.toJson(this, false);
    }
}
