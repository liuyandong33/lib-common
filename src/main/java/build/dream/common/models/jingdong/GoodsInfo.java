package build.dream.common.models.jingdong;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.GsonUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

public class GoodsInfo extends BasicModel {
    private static final String[] TYPES = {"GT01", "GT02"};
    @Length(max = 30)
    private String id;

    @Length(max = 10)
    private String cat1;

    @Length(max = 10)
    private String cat2;

    @Length(max = 10)
    private String cat3;

    private String type;

    private Long price;

    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean validate() {
        boolean isValidate = super.validate();
        if (!isValidate) {
            return false;
        }
        if (StringUtils.isNotBlank(type) && !ArrayUtils.contains(TYPES, type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return GsonUtils.toJson(this, false);
    }
}
