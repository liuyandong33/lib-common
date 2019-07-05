package build.dream.common.models.dingtalk;

public class ListDepartmentsModel extends DingtalkBasicModel {
    private String lang;

    private Boolean fetchChild;

    private String id;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getFetchChild() {
        return fetchChild;
    }

    public void setFetchChild(Boolean fetchChild) {
        this.fetchChild = fetchChild;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Builder extends DingtalkBasicModel.Builder<Builder, ListDepartmentsModel> {
        public Builder lang(String lang) {
            instance.setLang(lang);
            return this;
        }

        public Builder fetchChild(Boolean fetchChild) {
            instance.setFetchChild(fetchChild);
            return this;
        }

        public Builder id(String id) {
            instance.setId(id);
            return this;
        }

        @Override
        public ListDepartmentsModel build() {
            ListDepartmentsModel listDepartmentsModel = super.build();
            listDepartmentsModel.setLang(instance.getLang());
            listDepartmentsModel.setFetchChild(instance.getFetchChild());
            listDepartmentsModel.setId(instance.getId());
            return listDepartmentsModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
