package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = Menu.FieldName.TENANT_ID, columnName = Menu.ColumnName.TENANT_ID)
public class MenuDetail extends BasicDomain {
    public static final String TABLE_NAME = "menu_detail";
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户编码
     */
    private String tenantCode;

    /**
     * 菜牌ID
     */
    private BigInteger menuId;

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

    /**
     * 售价
     */
    private BigDecimal price;

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

    public BigInteger getMenuId() {
        return menuId;
    }

    public void setMenuId(BigInteger menuId) {
        this.menuId = menuId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

        public Builder menuId(BigInteger menuId) {
            instance.setMenuId(menuId);
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

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
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
            menuDetail.setMenuId(instance.getMenuId());
            menuDetail.setGoodsId(instance.getGoodsId());
            menuDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            menuDetail.setGoodsUnitId(instance.getGoodsUnitId());
            menuDetail.setPrice(instance.getPrice());
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

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String MENU_ID = "menu_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String GOODS_UNIT_ID = "goods_unit_id";
        public static final String PRICE = "price";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String MENU_ID = "menuId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String GOODS_UNIT_ID = "goodsUnitId";
        public static final String PRICE = "price";
    }
}