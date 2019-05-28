package build.dream.common.basic;

import java.io.Serializable;

public interface IdDomain<T> extends Serializable {
    T getId();

    void setId(T id);
}
