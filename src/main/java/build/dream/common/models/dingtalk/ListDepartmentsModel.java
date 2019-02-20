package build.dream.common.models.dingtalk;

import build.dream.common.models.BasicModel;

public class ListDepartmentsModel extends BasicModel {
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
}
