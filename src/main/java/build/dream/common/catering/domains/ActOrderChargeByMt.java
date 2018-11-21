package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ActOrderChargeByMt extends BasicDomain {
    /**
     * mei_tuan_order_poi_receive_detail id
     */
    private BigInteger meiTuanOrderPoiReceiveDetailId;
    /**
     * 备注
     */
    private String comment;
    /**
     * 明细费用类型描述
     */
    private String feeTypeDesc;
    /**
     * 明细费用类型Id
     */
    private BigInteger feeTypeId;
    /**
     * 明细金额
     */
    private BigDecimal moneyCent;

    public BigInteger getMeiTuanOrderPoiReceiveDetailId() {
        return meiTuanOrderPoiReceiveDetailId;
    }

    public void setMeiTuanOrderPoiReceiveDetailId(BigInteger meiTuanOrderPoiReceiveDetailId) {
        this.meiTuanOrderPoiReceiveDetailId = meiTuanOrderPoiReceiveDetailId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeeTypeDesc() {
        return feeTypeDesc;
    }

    public void setFeeTypeDesc(String feeTypeDesc) {
        this.feeTypeDesc = feeTypeDesc;
    }

    public BigInteger getFeeTypeId() {
        return feeTypeId;
    }

    public void setFeeTypeId(BigInteger feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    public BigDecimal getMoneyCent() {
        return moneyCent;
    }

    public void setMoneyCent(BigDecimal moneyCent) {
        this.moneyCent = moneyCent;
    }

    public static class Builder {
        private final ActOrderChargeByMt instance = new ActOrderChargeByMt();

        public Builder meiTuanOrderPoiReceiveDetailId(BigInteger meiTuanOrderPoiReceiveDetailId) {
            instance.setMeiTuanOrderPoiReceiveDetailId(meiTuanOrderPoiReceiveDetailId);
            return this;
        }

        public Builder comment(String comment) {
            instance.setComment(comment);
            return this;
        }

        public Builder feeTypeDesc(String feeTypeDesc) {
            instance.setFeeTypeDesc(feeTypeDesc);
            return this;
        }

        public Builder feeTypeId(BigInteger feeTypeId) {
            instance.setFeeTypeId(feeTypeId);
            return this;
        }

        public Builder moneyCent(BigDecimal moneyCent) {
            instance.setMoneyCent(moneyCent);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ActOrderChargeByMt build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String MEI_TUAN_ORDER_POI_RECEIVE_DETAIL_ID = "mei_tuan_order_poi_receive_detail_id";
        public static final String COMMENT = "comment";
        public static final String FEE_TYPE_DESC = "fee_type_desc";
        public static final String FEE_TYPE_ID = "fee_type_id";
        public static final String MONEY_CENT = "money_cent";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String MEI_TUAN_ORDER_POI_RECEIVE_DETAIL_ID = "meiTuanOrderPoiReceiveDetailId";
        public static final String COMMENT = "comment";
        public static final String FEE_TYPE_DESC = "feeTypeDesc";
        public static final String FEE_TYPE_ID = "feeTypeId";
        public static final String MONEY_CENT = "moneyCent";
    }
}
