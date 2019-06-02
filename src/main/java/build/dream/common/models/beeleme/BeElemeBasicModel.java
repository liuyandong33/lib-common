package build.dream.common.models.beeleme;

import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class BeElemeBasicModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String source;

    @JsonIgnore
    private String encrypt;

    @JsonIgnore
    private String fields;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
