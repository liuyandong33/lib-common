package build.dream.common.models.jddj;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class UpdateSkuModel extends JDDJBasicModel {
    /**
     * 请求唯一编码
     */
    @NotNull
    private String traceId;

    /**
     * 商家skuId编码（商家skuId）
     */
    @NotNull
    private String outSkuId;

    /**
     * 商家店内分类编号列表，商家店内分类分两级，一个商品可以绑定多个店内分类（上传的店内分类需为最末级分类， 即二级店内分类或没有子分类的一级店内分类），店内分类编号通过查询商家店内分类信息接口获取。
     */
    private List<Long> shopCategories;

    /**
     * 到家类目编号，需传入到家的第三级分类（通过查询到家类目信息接口获取）
     */
    private Long categoryId;

    /**
     * 到家品牌编号（通过分页查询商品品牌信息接口获取）
     */
    private Long brandId;

    /**
     * 商品名称（格式：名称+规格）, 校验字符数（1-45字符），不能包含js代码
     */
    private String skuName;

    /**
     * 商家商品价格(单位：分)，用于初始商品门店价格，所有的商品门店价格都会初始化成该值。后续修改商品门店价格需要通过价格类接口修改。
     */
    private Long skuPrice;

    /**
     * 重量（单位：公斤/KG），小数点后最多保留3位
     */
    private Double weight;

    /**
     * UPC编码（商品条码），限1-35个字符，包装类的商品要求UPC编码必填，且要符合条码编写的校验，否则商品会不予通过，接口返回错误状态码code为10059。
     */
    private String upc;

    /**
     * 商品图片地址，图片数组中的顺序即图片顺序，默认第一张主图；图片要求：800*800 ，后缀格式只支持png或者jpg，最大不要超过1M；
     * 利用该接口上传图片时，图片为异步处理，请调用“查询商品图片处理结果接口”查看图片是否上传成功。图片不超过六张
     */
    private List<String> images;

    /**
     * 商品描述。支持图片和文字，若有文字描述，则不能少于10字符。限制为源码 不超过“30000”。
     */
    private String productDesc;

    /**
     * 商品描述是否在app端展示（0展示 1不展示）
     */
    private Integer ifViewDesc;

    /**
     * 广告词, 校验字符数1-45字符
     */
    @Length(min = 1, max = 45)
    private String slogan;

    /**
     * 广告词生效时间，当广告词字段有值时，该字段必填
     */
    private Date sloganStartTime;

    /**
     * 广告词失效时间，当广告词字段有值时，该字段必填。必须设置具体时间，时间长短无限制。
     */
    private Date sloganEndTime;

    /**
     * 前缀编码
     */
    private String prefixKeyId;

    /**
     * 前缀内容
     */
    private String prefixKey;

    /**
     * 前缀开始时间，前缀编码有值时，该字段必填
     */
    private Date preKeyStartTime;

    /**
     * 前缀结束时间，前缀编码有值时，该字段必填。必须设置具体时间，时间长短无限制
     */
    private Date preKeyEndTime;

    /**
     * 长(mm)
     */
    private Integer length;

    /**
     * 宽(mm)
     */
    private Integer width;

    /**
     * 高(mm)
     */
    private Integer height;

    /**
     * 储藏方式(0常温,1冷藏,2冷冻)
     */
    private String transportAttribute;

    /**
     * 是否液体(0是,1否)
     */
    private String liquidStatue;

    /**
     * 是否处方药(0否,1是)
     */
    private String prescripition;

    /**
     * 商家商品上下架状态：1.上架 2.下架
     */
    private Integer fixedStatus;

    /**
     * 门店商品可售状态(true/false)；新建商品时，如果为true，门店商品可售状态初始为可售，
     * 如果为false， 门店商品可售状态初始为不可售。后续修改各个门店商品可售状态时，请使用根据京东到家商品编码批量修改门店商品可售状态接口。
     */
    private Boolean isSale;

    /**
     * 城市ID，0为全国
     */
    private List<Long> sellCities;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getOutSkuId() {
        return outSkuId;
    }

    public void setOutSkuId(String outSkuId) {
        this.outSkuId = outSkuId;
    }

    public List<Long> getShopCategories() {
        return shopCategories;
    }

    public void setShopCategories(List<Long> shopCategories) {
        this.shopCategories = shopCategories;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Long getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Long skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getIfViewDesc() {
        return ifViewDesc;
    }

    public void setIfViewDesc(Integer ifViewDesc) {
        this.ifViewDesc = ifViewDesc;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Date getSloganStartTime() {
        return sloganStartTime;
    }

    public void setSloganStartTime(Date sloganStartTime) {
        this.sloganStartTime = sloganStartTime;
    }

    public Date getSloganEndTime() {
        return sloganEndTime;
    }

    public void setSloganEndTime(Date sloganEndTime) {
        this.sloganEndTime = sloganEndTime;
    }

    public String getPrefixKeyId() {
        return prefixKeyId;
    }

    public void setPrefixKeyId(String prefixKeyId) {
        this.prefixKeyId = prefixKeyId;
    }

    public String getPrefixKey() {
        return prefixKey;
    }

    public void setPrefixKey(String prefixKey) {
        this.prefixKey = prefixKey;
    }

    public Date getPreKeyStartTime() {
        return preKeyStartTime;
    }

    public void setPreKeyStartTime(Date preKeyStartTime) {
        this.preKeyStartTime = preKeyStartTime;
    }

    public Date getPreKeyEndTime() {
        return preKeyEndTime;
    }

    public void setPreKeyEndTime(Date preKeyEndTime) {
        this.preKeyEndTime = preKeyEndTime;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTransportAttribute() {
        return transportAttribute;
    }

    public void setTransportAttribute(String transportAttribute) {
        this.transportAttribute = transportAttribute;
    }

    public String getLiquidStatue() {
        return liquidStatue;
    }

    public void setLiquidStatue(String liquidStatue) {
        this.liquidStatue = liquidStatue;
    }

    public String getPrescripition() {
        return prescripition;
    }

    public void setPrescripition(String prescripition) {
        this.prescripition = prescripition;
    }

    public Integer getFixedStatus() {
        return fixedStatus;
    }

    public void setFixedStatus(Integer fixedStatus) {
        this.fixedStatus = fixedStatus;
    }

    public Boolean getIsSale() {
        return isSale;
    }

    public void setIsSale(Boolean isSale) {
        this.isSale = isSale;
    }

    public List<Long> getSellCities() {
        return sellCities;
    }

    public void setSellCities(List<Long> sellCities) {
        this.sellCities = sellCities;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateSkuModel> {
        public Builder traceId(String traceId) {
            instance.setTraceId(traceId);
            return this;
        }

        public Builder outSkuId(String outSkuId) {
            instance.setOutSkuId(outSkuId);
            return this;
        }

        public Builder shopCategories(List shopCategories) {
            instance.setShopCategories(shopCategories);
            return this;
        }

        public Builder categoryId(Long categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder brandId(Long brandId) {
            instance.setBrandId(brandId);
            return this;
        }

        public Builder skuName(String skuName) {
            instance.setSkuName(skuName);
            return this;
        }

        public Builder skuPrice(Long skuPrice) {
            instance.setSkuPrice(skuPrice);
            return this;
        }

        public Builder weight(Double weight) {
            instance.setWeight(weight);
            return this;
        }

        public Builder upc(String upc) {
            instance.setUpc(upc);
            return this;
        }

        public Builder images(List images) {
            instance.setImages(images);
            return this;
        }

        public Builder productDesc(String productDesc) {
            instance.setProductDesc(productDesc);
            return this;
        }

        public Builder ifViewDesc(Integer ifViewDesc) {
            instance.setIfViewDesc(ifViewDesc);
            return this;
        }

        public Builder slogan(String slogan) {
            instance.setSlogan(slogan);
            return this;
        }

        public Builder sloganStartTime(Date sloganStartTime) {
            instance.setSloganStartTime(sloganStartTime);
            return this;
        }

        public Builder sloganEndTime(Date sloganEndTime) {
            instance.setSloganEndTime(sloganEndTime);
            return this;
        }

        public Builder prefixKeyId(String prefixKeyId) {
            instance.setPrefixKeyId(prefixKeyId);
            return this;
        }

        public Builder prefixKey(String prefixKey) {
            instance.setPrefixKey(prefixKey);
            return this;
        }

        public Builder preKeyStartTime(Date preKeyStartTime) {
            instance.setPreKeyStartTime(preKeyStartTime);
            return this;
        }

        public Builder preKeyEndTime(Date preKeyEndTime) {
            instance.setPreKeyEndTime(preKeyEndTime);
            return this;
        }

        public Builder length(Integer length) {
            instance.setLength(length);
            return this;
        }

        public Builder width(Integer width) {
            instance.setWidth(width);
            return this;
        }

        public Builder height(Integer height) {
            instance.setHeight(height);
            return this;
        }

        public Builder transportAttribute(String transportAttribute) {
            instance.setTransportAttribute(transportAttribute);
            return this;
        }

        public Builder liquidStatue(String liquidStatue) {
            instance.setLiquidStatue(liquidStatue);
            return this;
        }

        public Builder prescripition(String prescripition) {
            instance.setPrescripition(prescripition);
            return this;
        }

        public Builder fixedStatus(Integer fixedStatus) {
            instance.setFixedStatus(fixedStatus);
            return this;
        }

        public Builder isSale(Boolean isSale) {
            instance.setIsSale(isSale);
            return this;
        }

        public Builder sellCities(List sellCities) {
            instance.setSellCities(sellCities);
            return this;
        }

        @Override
        public UpdateSkuModel build() {
            UpdateSkuModel updateSkuModel = super.build();
            updateSkuModel.setTraceId(instance.getTraceId());
            updateSkuModel.setOutSkuId(instance.getOutSkuId());
            updateSkuModel.setShopCategories(instance.getShopCategories());
            updateSkuModel.setCategoryId(instance.getCategoryId());
            updateSkuModel.setBrandId(instance.getBrandId());
            updateSkuModel.setSkuName(instance.getSkuName());
            updateSkuModel.setSkuPrice(instance.getSkuPrice());
            updateSkuModel.setWeight(instance.getWeight());
            updateSkuModel.setUpc(instance.getUpc());
            updateSkuModel.setImages(instance.getImages());
            updateSkuModel.setProductDesc(instance.getProductDesc());
            updateSkuModel.setIfViewDesc(instance.getIfViewDesc());
            updateSkuModel.setSlogan(instance.getSlogan());
            updateSkuModel.setSloganStartTime(instance.getSloganStartTime());
            updateSkuModel.setSloganEndTime(instance.getSloganEndTime());
            updateSkuModel.setPrefixKeyId(instance.getPrefixKeyId());
            updateSkuModel.setPrefixKey(instance.getPrefixKey());
            updateSkuModel.setPreKeyStartTime(instance.getPreKeyStartTime());
            updateSkuModel.setPreKeyEndTime(instance.getPreKeyEndTime());
            updateSkuModel.setLength(instance.getLength());
            updateSkuModel.setWidth(instance.getWidth());
            updateSkuModel.setHeight(instance.getHeight());
            updateSkuModel.setTransportAttribute(instance.getTransportAttribute());
            updateSkuModel.setLiquidStatue(instance.getLiquidStatue());
            updateSkuModel.setPrescripition(instance.getPrescripition());
            updateSkuModel.setFixedStatus(instance.getFixedStatus());
            updateSkuModel.setIsSale(instance.getIsSale());
            updateSkuModel.setSellCities(instance.getSellCities());
            return updateSkuModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
