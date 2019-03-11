package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class MenuDetail extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户编码
     */
    private String tenantCode;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;

    /**
     * 商品单位ID
     */
    private BigInteger goodsUnitId;

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

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public BigInteger getGoodsUnitId() {
        return goodsUnitId;
    }

    public void setGoodsUnitId(BigInteger goodsUnitId) {
        this.goodsUnitId = goodsUnitId;
    }


    public static class Builder {
        private final MenuDetail instance = new MenuDetail();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsUnitId(BigInteger goodsUnitId) {
            instance.setGoodsUnitId(goodsUnitId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public MenuDetail build() {
            MenuDetail menuDetail = new MenuDetail();
            menuDetail.setTenantId(instance.getTenantId());
            menuDetail.setTenantCode(instance.getTenantCode());
            menuDetail.setGoodsId(instance.getGoodsId());
            menuDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            menuDetail.setGoodsUnitId(instance.getGoodsUnitId());
            menuDetail.setId(instance.getId());
            menuDetail.setCreatedTime(instance.getCreatedTime());
            menuDetail.setCreatedUserId(instance.getCreatedUserId());
            menuDetail.setUpdatedTime(instance.getUpdatedTime());
            menuDetail.setUpdatedUserId(instance.getUpdatedUserId());
            menuDetail.setUpdatedRemark(instance.getUpdatedRemark());
            menuDetail.setDeletedTime(instance.getDeletedTime());
            menuDetail.setDeleted(instance.isDeleted());
            return menuDetail;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}