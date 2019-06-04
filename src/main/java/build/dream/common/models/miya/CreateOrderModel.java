package build.dream.common.models.miya;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CreateOrderModel extends BasicModel {
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
    @InList(value = {"JSAPI", "APP", "H5", "WXA"})
    private String a11;

    @NotNull
    @InList(value = {"1", "3"})
    private String a12;

    @NotNull
    @Length(max = 32)
    private String b1;

    @NotNull
    @Length(max = 64)
    private String b3;

    @NotNull
    @Length(max = 12)
    private String b4;

    @Length(max = 20480)
    private String b5;

    @Length(max = 64)
    private String b11;

    @Length(max = 100)
    private String b12;

    @NotNull
    @Length(max = 100)
    private String b13;

    @Length(max = 100)
    private String b14;

    @Length(max = 32)
    private String b16;

    @Length(max = 20)
    private String b17;

    @Length(max = 20)
    private String b18;

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

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
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

    public String getB11() {
        return b11;
    }

    public void setB11(String b11) {
        this.b11 = b11;
    }

    public String getB12() {
        return b12;
    }

    public void setB12(String b12) {
        this.b12 = b12;
    }

    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13;
    }

    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14;
    }

    public String getB16() {
        return b16;
    }

    public void setB16(String b16) {
        this.b16 = b16;
    }

    public String getB17() {
        return b17;
    }

    public void setB17(String b17) {
        this.b17 = b17;
    }

    public String getB18() {
        return b18;
    }

    public void setB18(String b18) {
        this.b18 = b18;
    }

    public static class Builder {
        private final CreateOrderModel instance = new CreateOrderModel();

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

        public Builder a11(String a11) {
            instance.setA11(a11);
            return this;
        }

        public Builder a12(String a12) {
            instance.setA12(a12);
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

        public Builder b11(String b11) {
            instance.setB11(b11);
            return this;
        }

        public Builder b12(String b12) {
            instance.setB12(b12);
            return this;
        }

        public Builder b13(String b13) {
            instance.setB13(b13);
            return this;
        }

        public Builder b14(String b14) {
            instance.setB14(b14);
            return this;
        }

        public Builder b16(String b16) {
            instance.setB16(b16);
            return this;
        }

        public Builder b17(String b17) {
            instance.setB17(b17);
            return this;
        }

        public Builder b18(String b18) {
            instance.setB18(b18);
            return this;
        }

        public CreateOrderModel build() {
            CreateOrderModel createOrderModel = new CreateOrderModel();
            createOrderModel.setTenantId(instance.getTenantId());
            createOrderModel.setBranchId(instance.getBranchId());
            createOrderModel.setA4(instance.getA4());
            createOrderModel.setA5(instance.getA5());
            createOrderModel.setA11(instance.getA11());
            createOrderModel.setA12(instance.getA12());
            createOrderModel.setB1(instance.getB1());
            createOrderModel.setB3(instance.getB3());
            createOrderModel.setB4(instance.getB4());
            createOrderModel.setB5(instance.getB5());
            createOrderModel.setB11(instance.getB11());
            createOrderModel.setB12(instance.getB12());
            createOrderModel.setB13(instance.getB13());
            createOrderModel.setB14(instance.getB14());
            createOrderModel.setB16(instance.getB16());
            createOrderModel.setB17(instance.getB17());
            createOrderModel.setB18(instance.getB18());
            return createOrderModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
