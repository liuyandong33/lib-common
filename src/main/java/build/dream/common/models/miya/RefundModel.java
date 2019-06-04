package build.dream.common.models.miya;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RefundModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @NotNull
    @Length(max = 10)
    private String a4;

    @NotNull
    @Length(max = 20)
    private String a5;

    @NotNull
    @Length(max = 32)
    private String b1;

    @NotNull
    @Length(max = 32)
    private String b2;

    @NotNull
    @Length(max = 12)
    private String b4;

    @Length(max = 20480)
    private String b5;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB4() {
        return b4;
    }

    public void setB4(String b4) {
        this.b4 = b4;
    }

    public String getB5() {
        return b5;
    }

    public void setB5(String b5) {
        this.b5 = b5;
    }

    public static class Builder {
        private final RefundModel instance = new RefundModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder a4(String a4) {
            instance.setA4(a4);
            return this;
        }

        public Builder a5(String a5) {
            instance.setA5(a5);
            return this;
        }

        public Builder b1(String b1) {
            instance.setB1(b1);
            return this;
        }

        public Builder b2(String b2) {
            instance.setB2(b2);
            return this;
        }

        public Builder b4(String b4) {
            instance.setB4(b4);
            return this;
        }

        public Builder b5(String b5) {
            instance.setB5(b5);
            return this;
        }

        public RefundModel build() {
            RefundModel refundModel = new RefundModel();
            refundModel.setTenantId(instance.getTenantId());
            refundModel.setBranchId(instance.getBranchId());
            refundModel.setA4(instance.getA4());
            refundModel.setA5(instance.getA5());
            refundModel.setB1(instance.getB1());
            refundModel.setB2(instance.getB2());
            refundModel.setB4(instance.getB4());
            refundModel.setB5(instance.getB5());
            return refundModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
