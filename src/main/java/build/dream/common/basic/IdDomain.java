package build.dream.common.basic;

import build.dream.common.annotations.GeneratedValue;
import build.dream.common.annotations.GenerationType;
import build.dream.common.annotations.Id;
import build.dream.common.annotations.UpdateIgnore;

import java.io.Serializable;
import java.math.BigInteger;

public class IdDomain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO_INCREMENT)
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
