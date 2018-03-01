package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class Goods extends BasicDomain {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品类型，1-设备，2-基础服务，3-增值服务
     */
    private Integer type;
    /**
     * 商品状态，1-正常，2-停售
     */
    private Integer status;
    /**
     * 图片路径
     */
    private String photoUrl;
    /**
     * 计量方式，1-按时间，2-按数量
     */
    private Integer meteringMode;
    /**
     * 业态，1-餐饮，2-零售
     */
    private String business;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getMeteringMode() {
        return meteringMode;
    }

    public void setMeteringMode(Integer meteringMode) {
        this.meteringMode = meteringMode;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}