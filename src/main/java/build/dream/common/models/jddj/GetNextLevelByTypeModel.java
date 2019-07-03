package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class GetNextLevelByTypeModel extends JDDJBasicModel {
    /**
     * 操作人
     */
    @NotNull
    private String pin;

    /**
     * 城市编码
     */
    @NotNull
    private Long areaCode;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Long areaCode) {
        this.areaCode = areaCode;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, GetNextLevelByTypeModel> {
        public Builder pin(String pin) {
            instance.setPin(pin);
            return this;
        }

        public Builder areaCode(Long areaCode) {
            instance.setAreaCode(areaCode);
            return this;
        }

        @Override
        public GetNextLevelByTypeModel build() {
            GetNextLevelByTypeModel getNextLevelByTypeModel = super.build();
            getNextLevelByTypeModel.setPin(instance.getPin());
            getNextLevelByTypeModel.setAreaCode(instance.getAreaCode());
            return getNextLevelByTypeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
