package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class Goods extends BasicDomain {
    private String name;
    private Integer goodsType;
    private Integer goodsStatus;
    private String goodsPhotoUrl;
    private Integer meteringMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsPhotoUrl() {
        return goodsPhotoUrl;
    }

    public void setGoodsPhotoUrl(String goodsPhotoUrl) {
        this.goodsPhotoUrl = goodsPhotoUrl;
    }

    public Integer getMeteringMode() {
        return meteringMode;
    }

    public void setMeteringMode(Integer meteringMode) {
        this.meteringMode = meteringMode;
    }
}
