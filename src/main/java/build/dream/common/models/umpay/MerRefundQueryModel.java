package build.dream.common.models.umpay;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class MerRefundQueryModel extends UmPayBasicModel {
    @NotNull
    @Length(max = 16)
    private String refundNo;

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public static class Builder extends UmPayBasicModel.Builder<Builder, MerRefundQueryModel> {
        public Builder refundNo(String refundNo) {
            instance.setRefundNo(refundNo);
            return this;
        }

        @Override
        public MerRefundQueryModel build() {
            MerRefundQueryModel merRefundQueryModel = super.build();
            merRefundQueryModel.setRefundNo(instance.getRefundNo());
            return merRefundQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
