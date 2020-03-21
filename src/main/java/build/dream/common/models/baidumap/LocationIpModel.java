package build.dream.common.models.baidumap;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class LocationIpModel extends BasicModel {
    /**
     * 用户上网的IP地址，请求中如果不出现或为空，会针对发来请求的IP进行定位
     */
    private String ip;

    /**
     * 开发者密钥
     */
    @NotNull
    private String ak;

    /**
     * 若用户所用AK的校验方式为SN校验时该参数必填。其他AK校验方式的可不填写
     */
    private String sn;

    /**
     * 设置返回位置信息中，经纬度的坐标类型，分别如下：
     * coor不出现、或为空：百度墨卡托坐标，即百度米制坐标
     * coor = bd09ll：百度经纬度坐标，在国测局坐标基础之上二次加密而来
     * coor = gcj02：国测局02坐标，在原始GPS坐标基础上，按照国家测绘行业统一要求，加密后的坐标
     */
    @InList(value = {Constants.BD09LL, Constants.GCJ02})
    private String coor;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCoor() {
        return coor;
    }

    public void setCoor(String coor) {
        this.coor = coor;
    }

    public static class Builder {
        private final LocationIpModel instance = new LocationIpModel();

        public Builder ip(String ip) {
            instance.setIp(ip);
            return this;
        }

        public Builder ak(String ak) {
            instance.setAk(ak);
            return this;
        }

        public Builder sn(String sn) {
            instance.setSn(sn);
            return this;
        }

        public Builder coor(String coor) {
            instance.setCoor(coor);
            return this;
        }

        public LocationIpModel build() {
            LocationIpModel locationIpModel = new LocationIpModel();
            locationIpModel.setIp(instance.getIp());
            locationIpModel.setAk(instance.getAk());
            locationIpModel.setSn(instance.getSn());
            locationIpModel.setCoor(instance.getCoor());
            return locationIpModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
