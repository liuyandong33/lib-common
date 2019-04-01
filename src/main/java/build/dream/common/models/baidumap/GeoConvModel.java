package build.dream.common.models.baidumap;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class GeoConvModel extends BasicModel {
    /**
     * 需转换的源坐标，多组坐标以“；”分隔
     * （经度，纬度）
     */
    @NotNull
    private String coords;

    /**
     * 开发者密钥
     */
    @NotNull
    private String ak;

    /**
     * 源坐标类型：
     * 1：GPS设备获取的角度坐标，WGS84坐标;
     * 2：GPS获取的米制坐标、sogou地图所用坐标;
     * 3：google地图、soso地图、aliyun地图、mapabc地图和amap地图所用坐标，国测局（GCJ02）坐标;
     * 4：3中列表地图坐标对应的米制坐标;
     * 5：百度地图采用的经纬度坐标;
     * 6：百度地图采用的米制坐标;
     * 7：mapbar地图坐标;
     * 8：51地图坐标
     */
    @NotNull
    @InList(value = {"1", "2", "3", "4", "5", "6", "7", "8"})
    private String from;

    /**
     * 目标坐标类型：
     * 3：国测局（GCJ02）坐标;
     * 4：3中对应的米制坐标;
     * 5：bd09ll(百度经纬度坐标);
     * 6：bd09mc(百度米制经纬度坐标)
     */
    @NotNull
    @InList(value = {"3", "4", "5", "6"})
    private String to;

    private String sn;

    private String output;

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public static class Builder {
        private final GeoConvModel instance = new GeoConvModel();

        public Builder coords(String coords) {
            instance.setCoords(coords);
            return this;
        }

        public Builder ak(String ak) {
            instance.setAk(ak);
            return this;
        }

        public Builder from(String from) {
            instance.setFrom(from);
            return this;
        }

        public Builder to(String to) {
            instance.setTo(to);
            return this;
        }

        public Builder sn(String sn) {
            instance.setSn(sn);
            return this;
        }

        public Builder output(String output) {
            instance.setOutput(output);
            return this;
        }

        public GeoConvModel build() {
            GeoConvModel geoConvModel = new GeoConvModel();
            geoConvModel.setCoords(instance.getCoords());
            geoConvModel.setAk(instance.getAk());
            geoConvModel.setFrom(instance.getFrom());
            geoConvModel.setTo(instance.getTo());
            geoConvModel.setSn(instance.getSn());
            geoConvModel.setOutput(instance.getOutput());
            return geoConvModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}