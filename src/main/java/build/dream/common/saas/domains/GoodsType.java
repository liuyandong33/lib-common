package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

public class GoodsType extends BasicDomain {
    private String name;
    private String description;
    private boolean single;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }
}
