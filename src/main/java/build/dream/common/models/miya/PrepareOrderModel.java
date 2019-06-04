package build.dream.common.models.miya;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PrepareOrderModel extends BasicModel {
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

    @Length(max = 30)
    private String a10;

    @NotNull
    @InList(value = {"1", "3"})
    private String a12;

    @NotNull
    @Length(max = 32)
    private String b1;

    @Length(max = 64)
    private String b3;

    @NotNull
    @Length(max = 12)
    private String b4;

    @Length(max = 20480)
    private String b5;

    @Length(max = 100)
    private String b13;

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

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
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

    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13;
    }

    public static class Builder {
        private final PrepareOrderModel instance = new PrepareOrderModel();

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

        public Builder b3(String b3) {
            instance.setB3(b3);
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

        public Builder b13(String b13) {
            instance.setB13(b13);
            return this;
        }

        public PrepareOrderModel build() {
            PrepareOrderModel prepareOrderModel = new PrepareOrderModel();
            prepareOrderModel.setTenantId(instance.getTenantId());
            prepareOrderModel.setBranchId(instance.getBranchId());
            prepareOrderModel.setA4(instance.getA4());
            prepareOrderModel.setA5(instance.getA5());
            prepareOrderModel.setB1(instance.getB1());
            prepareOrderModel.setB3(instance.getB3());
            prepareOrderModel.setB4(instance.getB4());
            prepareOrderModel.setB5(instance.getB5());
            prepareOrderModel.setB13(instance.getB13());
            return prepareOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
