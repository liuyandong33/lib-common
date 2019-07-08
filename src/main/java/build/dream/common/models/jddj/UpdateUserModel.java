package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class UpdateUserModel extends JDDJBasicModel {
    /**
     * 用户id
     */
    @NotNull
    private Long id;

    /**
     * 状态(0:启用，1:禁用)
     */
    @NotNull
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder extends JDDJBasicModel.Builder<Builder, UpdateUserModel> {
        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        @Override
        public UpdateUserModel build() {
            UpdateUserModel updateUserModel = super.build();
            updateUserModel.setId(instance.getId());
            updateUserModel.setStatus(instance.getStatus());
            return updateUserModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
