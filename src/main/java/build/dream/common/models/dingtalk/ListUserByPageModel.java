package build.dream.common.models.dingtalk;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ListUserByPageModel extends DingtalkBasicModel {
    private String lang;

    @NotNull
    private String departmentId;

    @NotNull
    @Min(value = 1)
    private Integer offset;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer size;

    private String order;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public static class Builder extends DingtalkBasicModel.Builder<Builder, ListUserByPageModel> {
        public Builder lang(String lang) {
            instance.setLang(lang);
            return this;
        }

        public Builder departmentId(String departmentId) {
            instance.setDepartmentId(departmentId);
            return this;
        }

        public Builder offset(Integer offset) {
            instance.setOffset(offset);
            return this;
        }

        public Builder size(Integer size) {
            instance.setSize(size);
            return this;
        }

        public Builder order(String order) {
            instance.setOrder(order);
            return this;
        }

        @Override
        public ListUserByPageModel build() {
            ListUserByPageModel listUserByPageModel = super.build();
            listUserByPageModel.setLang(instance.getLang());
            listUserByPageModel.setDepartmentId(instance.getDepartmentId());
            listUserByPageModel.setOffset(instance.getOffset());
            listUserByPageModel.setSize(instance.getSize());
            listUserByPageModel.setOrder(instance.getOrder());
            return listUserByPageModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
