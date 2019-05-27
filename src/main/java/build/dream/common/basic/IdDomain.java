package build.dream.common.basic;

import build.dream.common.annotations.UpdateIgnore;

import java.io.Serializable;
import java.math.BigInteger;

public class IdDomain implements Serializable {
    @UpdateIgnore
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public static class ColumnName {
        public static final String ID = "id";
    }

    public static class FieldName {
        public static final String ID = "id";
    }
}
