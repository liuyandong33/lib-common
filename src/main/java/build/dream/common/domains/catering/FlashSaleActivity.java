package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class FlashSaleActivity extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户编号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private BigInteger branchId;

    /**
     * 秒杀活动名称
     */
    private String name;

    /**
     * 活动状态，1-未终止，2-已终止
     */
    private Integer status;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 是否限购，1-限购，0-不限购
     */
    private boolean limited;

    /**
     * 限购数量
     */
    private BigDecimal limitQuantity;

    /**
     * 生效前显示时间
     */
    private Integer beforeShowTime;

    /**
     * 时间单位，1-天，2-小时，3-分钟
     */
    private Integer timeUnit;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片地址
     */
    private String imageUrl;

    /**
     * 商品原价
     */
    private BigDecimal originalPrice;

    /**
     * 秒杀价
     */
    private BigDecimal flashSalePrice;

    /**
     * 秒杀库存
     */
    private BigDecimal flashSaleStock;

    /**
     * 活动说明
     */
    private String description;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }

    public BigDecimal getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(BigDecimal limitQuantity) {
        this.limitQuantity = limitQuantity;
    }

    public Integer getBeforeShowTime() {
        return beforeShowTime;
    }

    public void setBeforeShowTime(Integer beforeShowTime) {
        this.beforeShowTime = beforeShowTime;
    }

    public Integer getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(Integer timeUnit) {
        this.timeUnit = timeUnit;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getFlashSalePrice() {
        return flashSalePrice;
    }

    public void setFlashSalePrice(BigDecimal flashSalePrice) {
        this.flashSalePrice = flashSalePrice;
    }

    public BigDecimal getFlashSaleStock() {
        return flashSaleStock;
    }

    public void setFlashSaleStock(BigDecimal flashSaleStock) {
        this.flashSaleStock = flashSaleStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder extends BasicDomain.Builder<Builder, FlashSaleActivity> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder startTime(Date startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Date endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder limited(boolean limited) {
            instance.setLimited(limited);
            return this;
        }

        public Builder limitQuantity(BigDecimal limitQuantity) {
            instance.setLimitQuantity(limitQuantity);
            return this;
        }

        public Builder beforeShowTime(Integer beforeShowTime) {
            instance.setBeforeShowTime(beforeShowTime);
            return this;
        }

        public Builder timeUnit(Integer timeUnit) {
            instance.setTimeUnit(timeUnit);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            instance.setImageUrl(imageUrl);
            return this;
        }

        public Builder originalPrice(BigDecimal originalPrice) {
            instance.setOriginalPrice(originalPrice);
            return this;
        }

        public Builder flashSalePrice(BigDecimal flashSalePrice) {
            instance.setFlashSalePrice(flashSalePrice);
            return this;
        }

        public Builder flashSaleStock(BigDecimal flashSaleStock) {
            instance.setFlashSaleStock(flashSaleStock);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        @Override
        public FlashSaleActivity build() {
            FlashSaleActivity flashSaleActivity = super.build();
            flashSaleActivity.setTenantId(instance.getTenantId());
            flashSaleActivity.setTenantCode(instance.getTenantCode());
            flashSaleActivity.setBranchId(instance.getBranchId());
            flashSaleActivity.setName(instance.getName());
            flashSaleActivity.setStatus(instance.getStatus());
            flashSaleActivity.setStartTime(instance.getStartTime());
            flashSaleActivity.setEndTime(instance.getEndTime());
            flashSaleActivity.setLimited(instance.isLimited());
            flashSaleActivity.setLimitQuantity(instance.getLimitQuantity());
            flashSaleActivity.setBeforeShowTime(instance.getBeforeShowTime());
            flashSaleActivity.setTimeUnit(instance.getTimeUnit());
            flashSaleActivity.setGoodsId(instance.getGoodsId());
            flashSaleActivity.setGoodsName(instance.getGoodsName());
            flashSaleActivity.setImageUrl(instance.getImageUrl());
            flashSaleActivity.setOriginalPrice(instance.getOriginalPrice());
            flashSaleActivity.setFlashSalePrice(instance.getFlashSalePrice());
            flashSaleActivity.setFlashSaleStock(instance.getFlashSaleStock());
            flashSaleActivity.setDescription(instance.getDescription());
            return flashSaleActivity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
        public static final String LIMITED = "limited";
        public static final String LIMIT_QUANTITY = "limit_quantity";
        public static final String BEFORE_SHOW_TIME = "before_show_time";
        public static final String TIME_UNIT = "time_unit";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_NAME = "goods_name";
        public static final String IMAGE_URL = "image_url";
        public static final String ORIGINAL_PRICE = "original_price";
        public static final String FLASH_SALE_PRICE = "flash_sale_price";
        public static final String FLASH_SALE_STOCK = "flash_sale_stock";
        public static final String DESCRIPTION = "description";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String LIMITED = "limited";
        public static final String LIMIT_QUANTITY = "limitQuantity";
        public static final String BEFORE_SHOW_TIME = "beforeShowTime";
        public static final String TIME_UNIT = "timeUnit";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_NAME = "goodsName";
        public static final String IMAGE_URL = "imageUrl";
        public static final String ORIGINAL_PRICE = "originalPrice";
        public static final String FLASH_SALE_PRICE = "flashSalePrice";
        public static final String FLASH_SALE_STOCK = "flashSaleStock";
        public static final String DESCRIPTION = "description";
    }
}
