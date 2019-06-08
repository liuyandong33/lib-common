package build.dream.common.models.miya;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ObjectUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MiyaBasicModel extends BasicModel {
    /**
     * 商户号
     */
    @NotNull
    @Length(max = 32)
    private String a2;

    /**
     * 门店账号
     */
    @NotNull
    @Length(max = 10)
    private String a3;

    /**
     * 设备号
     */
    @NotNull
    @Length(max = 10)
    private String a4;

    /**
     * 收银编号
     */
    @NotNull
    @Length(max = 20)
    private String a5;

    /**
     * 版本号
     */
    @NotNull
    @Length(max = 5)
    private String a7 = Constants.MIYA_API_VERSION;

    @NotNull
    private String miyaKey;

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
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

    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }

    public String getMiyaKey() {
        return miyaKey;
    }

    public void setMiyaKey(String miyaKey) {
        this.miyaKey = miyaKey;
    }

    protected abstract static class Builder<BT extends Builder<BT, IT>, IT extends MiyaBasicModel> {
        private Class<IT> modelClass;
        protected IT instance;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<IT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT a2(String a2) {
            instance.setA2(a2);
            return (BT) this;
        }

        public BT a3(String a3) {
            instance.setA3(a3);
            return (BT) this;
        }

        public BT a4(String a4) {
            instance.setA4(a4);
            return (BT) this;
        }

        public BT a5(String a5) {
            instance.setA5(a5);
            return (BT) this;
        }

        public BT a7(String a7) {
            instance.setA7(a7);
            return (BT) this;
        }

        public BT miyaKey(String miyaKey) {
            instance.setMiyaKey(miyaKey);
            return (BT) this;
        }

        protected IT build() {
            IT model = ObjectUtils.newInstance(modelClass);
            model.setA2(instance.getA2());
            model.setA3(instance.getA3());
            model.setA4(instance.getA4());
            model.setA5(instance.getA5());
            model.setA7(instance.getA7());
            model.setMiyaKey(instance.getMiyaKey());
            return model;
        }
    }
}
